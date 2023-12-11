package com.wordpress.ecommerce.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.wordpress.ecommerce.helper.Helper;
import com.wordpress.ecommerce.objects.EcomProduct;
import com.wordpress.ecommerce.objects.product1.Product1;
import com.wordpress.ecommerce.objects.product2.Product2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class CreateEcommerceData {
    public String jsonToCsv(String jsonFilePath, String csvFilePath)  {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(jsonFilePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            Set<String> headers = collectHeaders(rootNode);

            writer.writeNext(headers.toArray(new String[0]));

            for (JsonNode node : rootNode) {
                String[] rowData = new String[headers.size()];
                int index = 0;
                for (String header : headers) {
                    rowData[index++] = node.has(header) ? node.get(header).asText() : "";
                }
                writer.writeNext(rowData);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return String.format("Exception occured: %s",e.getMessage());
        }
        return "CSV generated successfully!";
    }

    private Set<String> collectHeaders(JsonNode node) {
        Set<String> headers = new HashSet<>();
        Iterator<JsonNode> elements = node.elements();
        while (elements.hasNext()) {
            JsonNode next = elements.next();
            next.fieldNames().forEachRemaining(headers::add);
        }
        return headers;
    }
    public String ecommerceData(String dataSet1path, String dataSet2path, String jsonFilePath) throws IOException {
        List<EcomProduct>ecomProductsList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource(dataSet1path);
        List<Product1> products = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product1[].class));

        for(Product1 product:products){
            EcomProduct ecomProduct = new EcomProduct(String.valueOf(product.get_id()), product.getSchema().getName(), Helper.convertListToString(product.getProduct_features()),Helper.convertObjToString(product.getSpecifications().toString()),product.getSchema().getManufacturer(),product.getSchema().getBrand().getName(),0D,product.getSchema().getImage());
            ecomProductsList.add(ecomProduct);
        }

        resource = new ClassPathResource(dataSet2path);
        List<Product2> product2List = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product2[].class));
        for(Product2 product2:product2List){

            EcomProduct ecomProduct = new EcomProduct(product2.get_id(), product2.getProduct().getDetails().getDisplayName(), Helper.convertHTMLToList(product2.getProduct().getDetails().getLongDescription()), Helper.convertSpecifications(product2.getSpecifications()).toString(),product2.getProduct().getDetails().getManufacturer(),"",0D,Helper.extractUrls(product2.getMedia()));
            ecomProductsList.add(ecomProduct);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonProducts = mapper.writeValueAsString(ecomProductsList);
            FileWriter fileWriter = new FileWriter(jsonFilePath);
            fileWriter.write(jsonProducts);
            fileWriter.close();
            return String.format("Data created and stored in %s",jsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            return  String.format("Failed to generate and store dummy data : %s",e.getMessage());
        }
    }
}

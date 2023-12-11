package com.wordpress.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordpress.ecommerce.entity.ProductBrand;
import com.wordpress.ecommerce.entity.Manufacturer;
import com.wordpress.ecommerce.entity.Product;
import com.wordpress.ecommerce.objects.EcomProduct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DataImportService {
    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final BrandService brandService;

    public DataImportService(ProductService productService,
                             ManufacturerService manufacturerService,
                             BrandService brandService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.brandService = brandService;
    }

    public String importDataFromJsonAndSave(String ecommFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource(ecommFilePath);
            List<EcomProduct> products = Arrays.asList(objectMapper.readValue(resource.getInputStream(), EcomProduct[].class));

            for (EcomProduct data : products) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setName((String) data.getManufacturer());

                ProductBrand brand = new ProductBrand();
                brand.setName((String) data.getBrand());

                Product product = new Product(data.getId(), data.getProduct_name(),data.getPrice(), manufacturer, brand);

                manufacturerService.saveManufacturer(manufacturer);
                brandService.saveBrand(brand);
                productService.saveProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some error occurred!";
        }
        return "Success";
    }
}


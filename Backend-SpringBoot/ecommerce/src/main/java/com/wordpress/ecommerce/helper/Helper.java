package com.wordpress.ecommerce.helper;

import com.wordpress.ecommerce.objects.product2.Media;
import com.wordpress.ecommerce.objects.product2.Specification;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.*;

public class Helper {

    //Convert HTML String of <li> tag to List
    public static String convertHTMLToList(String htmlString) {
        if(htmlString == null || htmlString.length()==0) return "";
        List<String> resultList = new ArrayList<>();

        Document doc = Jsoup.parse(htmlString);

        for (Element li : doc.select("ul li")) {
            resultList.add(li.text());
        }

        return convertListToString(resultList);
    }

    //"[{"name": "Latex Free","value": ["Yes"]} -> {"Latex Free":"Yes"}
    public static String convertSpecifications(List<Specification> specifications) {
        Map<String, String> convertedSpecifications = new HashMap<>();

        for (Specification spec : specifications) {
            String name = spec.getName();
            List<String> values = spec.getValue();

            String value = String.join(", ", values);
            convertedSpecifications.put(name, value);
        }

        return convertObjToString(convertedSpecifications.toString());
    }

    //get image url where media is imagePrimary
    public static String extractUrls(List<Media> mediaList) {
        Optional<Media> firstImagePrimary = mediaList.stream()
                .filter(media -> "imagePrimary".equals(media.getType()))
                .findFirst();

        return firstImagePrimary.map(Media::getUrl).orElse(null);
    }

    public static String convertListToString(List<String> stringList) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {
            result.append('"').append(stringList.get(i)).append('"');
            if (i < stringList.size() - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    public static String convertObjToString(String str) {
        String[] parts = str.substring(1, str.length() - 1).split(",");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            result.append('"').append(parts[i].replaceAll("\"", "")).append('"');
            if (i < parts.length - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}

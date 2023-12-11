package com.wordpress.ecommerce.objects.product1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product1 {
    @Id
    private long _id;
    private String meta_title;
    private String page_title;
    private String meta_description;
    private int views;
    private String times_used;
    private String prod_title;
    private String prod_invoice_title;
    private List<String> tags;
    private List<Object> variation;
    @JsonProperty("product-features")
    private List<String> product_features;
    private List<Long> popularSuggest;
    private Object specifications;
    private List<Object> more_information;
    private long categoryId;
    private String created_at;
    private Schema schema;

    // Getters and setters
}
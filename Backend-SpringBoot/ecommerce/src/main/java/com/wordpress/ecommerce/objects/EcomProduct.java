package com.wordpress.ecommerce.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EcomProduct {
    String id;
    String product_name;
    String product_description;
    String specification;
    String manufacturer;
    String brand;
    double price;
    String imageUrl;

    EcomProduct(String id, String product_name, String product_description, String specification, String manufacturer, String brand, Double price, String imageUrl){
        this.id = id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.specification = specification;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

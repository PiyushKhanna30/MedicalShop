package com.wordpress.ecommerce.objects.product1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schema {
    @JsonProperty("@context")
    private String context;

    @JsonProperty("@type")
    private String type;

    private String name;
    private String image;
    private String description;
    private String manufacturer;
    private String mpn;
    private String model;
    private Brand brand;
}

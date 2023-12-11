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
public class Brand {
    @JsonProperty("@type")
    private String type;
    private String name;

}

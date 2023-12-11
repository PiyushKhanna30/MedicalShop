package com.wordpress.ecommerce.objects.product2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubProductDetails {
    private String longDescription;
    private String displayName;
    private String url;
    private String manufacturer;
}
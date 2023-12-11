package com.wordpress.ecommerce.objects.product2;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Product2 {
    @Id
    private String _id;
    private SubProduct product;
    private String material;
    private Object details;
    private List<Media> media;
    private List<Specification> specifications;
    private List<PackagingDetail> packagingDetails;

    @JsonIgnore
    private List<Documents> documents;
}


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Documents {
    private String name;
    private SubProductDetails type;
    private String url;
}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class PackagingDetail {
    private String baseUomDesc;
    private String uomDesc;
    private int length;
    private String casePack;
    private int volume;
    private double grossWeight;
    private double netWeight;
    private String uom;
    private boolean salesUom;
    private int width;
    private String gtinAndUpc;
    private String weightUom;
    private String volumeUom;
    private int conversion;
    private int height;
}

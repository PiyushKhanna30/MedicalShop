package com.wordpress.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Setter
@Getter
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
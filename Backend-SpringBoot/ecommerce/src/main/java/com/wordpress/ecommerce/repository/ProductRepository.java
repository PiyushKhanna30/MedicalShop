package com.wordpress.ecommerce.repository;

import com.wordpress.ecommerce.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product, String> {
}

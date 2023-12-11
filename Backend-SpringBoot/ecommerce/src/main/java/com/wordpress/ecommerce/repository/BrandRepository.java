package com.wordpress.ecommerce.repository;

import com.wordpress.ecommerce.entity.ProductBrand;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BrandRepository extends Neo4jRepository<ProductBrand, Long> {
}

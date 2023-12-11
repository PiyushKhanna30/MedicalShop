package com.wordpress.ecommerce.repository;

import com.wordpress.ecommerce.entity.Manufacturer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ManufacturerRepository extends Neo4jRepository<Manufacturer, Long> {
}

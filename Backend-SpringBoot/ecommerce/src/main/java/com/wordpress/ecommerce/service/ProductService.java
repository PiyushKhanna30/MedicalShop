package com.wordpress.ecommerce.service;

import com.wordpress.ecommerce.entity.Product;
import com.wordpress.ecommerce.repository.BrandRepository;
import com.wordpress.ecommerce.repository.ManufacturerRepository;
import com.wordpress.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository,
                          ManufacturerRepository manufacturerRepository,
                          BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.brandRepository = brandRepository;
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}


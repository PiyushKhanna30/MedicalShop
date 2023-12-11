package com.wordpress.ecommerce.service;

import com.wordpress.ecommerce.entity.ProductBrand;
import com.wordpress.ecommerce.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void saveBrand(ProductBrand brand) {
        brandRepository.save(brand);
    }
}


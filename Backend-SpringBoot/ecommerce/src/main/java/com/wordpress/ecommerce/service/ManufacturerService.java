package com.wordpress.ecommerce.service;

import com.wordpress.ecommerce.entity.Manufacturer;
import com.wordpress.ecommerce.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }
}

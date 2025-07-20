package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Brand;
import com.garagemaster.garagemaster_api.repository.BrandRepository;
import com.garagemaster.garagemaster_api.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(String id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(String id, Brand brand) {
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @Override
    public void delete(String id) {
        brandRepository.deleteById(id);
    }
}

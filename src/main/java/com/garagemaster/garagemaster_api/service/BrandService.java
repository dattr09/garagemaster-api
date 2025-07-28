package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Brand;
import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand getById(String id);
    Brand create(Brand brand);
    Brand update(String id, Brand brand);
    void delete(String id);
    
}

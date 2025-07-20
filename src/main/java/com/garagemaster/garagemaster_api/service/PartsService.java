package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Parts;
import java.util.List;

public interface PartsService {
    List<Parts> getAll();
    Parts getById(String id);
    Parts create(Parts part);
    Parts update(String id, Parts part);
    void delete(String id);
    List<Parts> searchByName(String name);
    List<Parts> getByBrandId(String brandId);
    Parts updateQuantity(String id, int quantityChange);
}

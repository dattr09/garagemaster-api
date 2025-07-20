package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Parts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartsRepository extends MongoRepository<Parts, String> {
    List<Parts> findByNameContainingIgnoreCase(String name);
    List<Parts> findByBrandId(String brandId);
}

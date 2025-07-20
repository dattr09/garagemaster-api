package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Moto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MotoRepository extends MongoRepository<Moto, String> {
    List<Moto> findByCustomerId(String customerId);
}

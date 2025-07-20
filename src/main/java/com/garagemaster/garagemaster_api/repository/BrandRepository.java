package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<Brand, String> {
    // Có thể thêm custom query nếu cần
}

package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {
    Optional<Review> findByUserId(String userId);
}

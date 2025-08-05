package com.garagemaster.garagemaster_api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garagemaster.garagemaster_api.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email); // Thêm dòng này
}
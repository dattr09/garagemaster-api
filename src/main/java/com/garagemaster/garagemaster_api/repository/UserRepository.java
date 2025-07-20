package com.garagemaster.garagemaster_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garagemaster.garagemaster_api.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
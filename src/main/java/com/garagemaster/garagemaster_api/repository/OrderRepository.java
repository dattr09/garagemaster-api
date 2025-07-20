package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerId(String customerId);
}

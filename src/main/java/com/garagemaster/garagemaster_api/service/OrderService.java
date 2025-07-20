package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(String id);
    Order create(Order order);
    void delete(String id);
    List<Order> getByCustomerId(String customerId);
}

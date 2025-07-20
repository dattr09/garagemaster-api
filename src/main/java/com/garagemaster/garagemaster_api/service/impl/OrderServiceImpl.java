package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Order;
import com.garagemaster.garagemaster_api.repository.OrderRepository;
import com.garagemaster.garagemaster_api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order create(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("Pending");
        return orderRepository.save(order);
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}

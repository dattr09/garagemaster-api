package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.RepairOrder;
import com.garagemaster.garagemaster_api.repository.RepairOrderRepository;
import com.garagemaster.garagemaster_api.service.RepairOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairOrderServiceImpl implements RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;

    @Override
    public List<RepairOrder> getAll() {
        return repairOrderRepository.findAll();
    }

    @Override
    public RepairOrder getById(String id) {
        return repairOrderRepository.findById(id).orElse(null);
    }

    @Override
    public RepairOrder create(RepairOrder order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return repairOrderRepository.save(order);
    }

    @Override
    public RepairOrder update(String id, RepairOrder order) {
        order.setId(id);
        order.setUpdatedAt(LocalDateTime.now());
        return repairOrderRepository.save(order);
    }

    @Override
    public void delete(String id) {
        repairOrderRepository.deleteById(id);
    }

    @Override
    public List<RepairOrder> getByCustomerId(String customerId) {
        return repairOrderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<RepairOrder> getByLicensePlate(String licensePlate) {
        return repairOrderRepository.findByLicensePlate(licensePlate);
    }
}

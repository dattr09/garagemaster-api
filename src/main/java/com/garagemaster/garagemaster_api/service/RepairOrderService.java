package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.RepairOrder;
import java.util.List;

public interface RepairOrderService {
    List<RepairOrder> getAll();
    RepairOrder getById(String id);
    RepairOrder create(RepairOrder order);
    RepairOrder update(String id, RepairOrder order);
    void delete(String id);
    List<RepairOrder> getByCustomerId(String customerId);
    List<RepairOrder> getByLicensePlate(String licensePlate);
}

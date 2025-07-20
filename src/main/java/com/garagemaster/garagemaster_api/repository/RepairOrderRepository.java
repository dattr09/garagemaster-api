package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.RepairOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepairOrderRepository extends MongoRepository<RepairOrder, String> {
    List<RepairOrder> findByCustomerId(String customerId);
    List<RepairOrder> findByLicensePlate(String licensePlate);
}

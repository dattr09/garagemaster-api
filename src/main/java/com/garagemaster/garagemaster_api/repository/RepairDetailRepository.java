package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.RepairDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepairDetailRepository extends MongoRepository<RepairDetail, String> {
    List<RepairDetail> findByRepairOrderId(String repairOrderId);
}

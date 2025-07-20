package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.RepairDetail;
import java.util.List;

public interface RepairDetailService {
    List<RepairDetail> getAll();
    RepairDetail getById(String id);
    RepairDetail create(RepairDetail detail);
    RepairDetail update(String id, RepairDetail detail);
    void delete(String id);
    List<RepairDetail> getByRepairOrderId(String repairOrderId);
}

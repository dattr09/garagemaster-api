package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.RepairDetail;
import com.garagemaster.garagemaster_api.repository.RepairDetailRepository;
import com.garagemaster.garagemaster_api.service.RepairDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairDetailServiceImpl implements RepairDetailService {
    private final RepairDetailRepository repairDetailRepository;

    @Override
    public List<RepairDetail> getAll() {
        return repairDetailRepository.findAll();
    }

    @Override
    public RepairDetail getById(String id) {
        return repairDetailRepository.findById(id).orElse(null);
    }

    @Override
    public RepairDetail create(RepairDetail detail) {
        // Tính lại totalPrice nếu cần
        detail.setTotalPrice(detail.getQuantity() * detail.getUnitPrice());
        return repairDetailRepository.save(detail);
    }

    @Override
    public RepairDetail update(String id, RepairDetail detail) {
        detail.setId(id);
        detail.setTotalPrice(detail.getQuantity() * detail.getUnitPrice());
        return repairDetailRepository.save(detail);
    }

    @Override
    public void delete(String id) {
        repairDetailRepository.deleteById(id);
    }

    @Override
    public List<RepairDetail> getByRepairOrderId(String repairOrderId) {
        return repairDetailRepository.findByRepairOrderId(repairOrderId);
    }
}

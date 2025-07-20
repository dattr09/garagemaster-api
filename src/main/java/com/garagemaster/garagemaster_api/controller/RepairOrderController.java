package com.garagemaster.garagemaster_api.controller;

import com.garagemaster.garagemaster_api.model.RepairOrder;
import com.garagemaster.garagemaster_api.service.RepairOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repairorders")
@RequiredArgsConstructor
public class RepairOrderController {
    private final RepairOrderService repairOrderService;

    @GetMapping
    public ResponseEntity<List<RepairOrder>> getAll() {
        return ResponseEntity.ok(repairOrderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairOrder> getById(@PathVariable String id) {
        RepairOrder order = repairOrderService.getById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<RepairOrder>> getByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(repairOrderService.getByCustomerId(customerId));
    }

    @GetMapping("/by-license/{licensePlate}")
    public ResponseEntity<List<RepairOrder>> getByLicensePlate(@PathVariable String licensePlate) {
        return ResponseEntity.ok(repairOrderService.getByLicensePlate(licensePlate));
    }

    @PostMapping
    public ResponseEntity<RepairOrder> create(@RequestBody RepairOrder order) {
        return ResponseEntity.ok(repairOrderService.create(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepairOrder> update(@PathVariable String id, @RequestBody RepairOrder order) {
        return ResponseEntity.ok(repairOrderService.update(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        repairOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

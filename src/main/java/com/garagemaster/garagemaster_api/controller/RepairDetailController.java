package com.garagemaster.garagemaster_api.controller;

import com.garagemaster.garagemaster_api.model.RepairDetail;
import com.garagemaster.garagemaster_api.service.RepairDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repairdetails")
@RequiredArgsConstructor
public class RepairDetailController {
    private final RepairDetailService repairDetailService;

    @GetMapping
    public ResponseEntity<List<RepairDetail>> getAll() {
        return ResponseEntity.ok(repairDetailService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairDetail> getById(@PathVariable String id) {
        RepairDetail detail = repairDetailService.getById(id);
        return detail != null ? ResponseEntity.ok(detail) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RepairDetail> create(@RequestBody RepairDetail detail) {
        return ResponseEntity.ok(repairDetailService.create(detail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepairDetail> update(@PathVariable String id, @RequestBody RepairDetail detail) {
        return ResponseEntity.ok(repairDetailService.update(id, detail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        repairDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/{repairOrderId}")
    public ResponseEntity<List<RepairDetail>> getByRepairOrderId(@PathVariable String repairOrderId) {
        return ResponseEntity.ok(repairDetailService.getByRepairOrderId(repairOrderId));
    }
}

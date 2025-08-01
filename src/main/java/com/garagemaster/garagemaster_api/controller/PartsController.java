package com.garagemaster.garagemaster_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garagemaster.garagemaster_api.model.Parts;
import com.garagemaster.garagemaster_api.service.PartsService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/parts")
@RequiredArgsConstructor
public class PartsController {
    private final PartsService partsService;

    @GetMapping
    public ResponseEntity<List<Parts>> getAll() {
        return ResponseEntity.ok(partsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parts> getById(@PathVariable String id) {
        Parts part = partsService.getById(id);
        return part != null ? ResponseEntity.ok(part) : ResponseEntity.notFound().build();
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Parts>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(partsService.searchByName(name));
    }

    @GetMapping("/byBrand/{brandId}")
    public ResponseEntity<List<Parts>> getByBrandId(@PathVariable String brandId) {
        return ResponseEntity.ok(partsService.getByBrandId(brandId));
    }

    @PostMapping

    public ResponseEntity<Parts> create(@RequestBody Parts part) {
        return ResponseEntity.ok(partsService.create(part));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parts> update(@PathVariable String id, @RequestBody Parts part) {
        return ResponseEntity.ok(partsService.update(id, part));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        partsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<Parts> updateQuantity(@PathVariable String id, @RequestBody QuantityUpdateModel model) {
        Parts updated = partsService.updateQuantity(id, model.getQuantityChange());
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @Data
    public static class QuantityUpdateModel {
        private int quantityChange;
    }
}

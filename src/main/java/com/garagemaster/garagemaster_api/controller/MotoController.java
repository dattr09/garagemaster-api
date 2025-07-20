package com.garagemaster.garagemaster_api.controller;

import com.garagemaster.garagemaster_api.model.Moto;
import com.garagemaster.garagemaster_api.service.MotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
public class MotoController {
    private final MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getAll() {
        return ResponseEntity.ok(motoService.getAll());
    }

    @GetMapping("/{licensePlate}")
    public ResponseEntity<Moto> getByLicensePlate(@PathVariable String licensePlate) {
        Moto moto = motoService.getByLicensePlate(licensePlate);
        return moto != null ? ResponseEntity.ok(moto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<Moto>> getByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(motoService.getByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<Moto> create(@RequestBody Moto moto) {
        return ResponseEntity.ok(motoService.create(moto));
    }

    @PutMapping("/{licensePlate}")
    public ResponseEntity<Moto> update(@PathVariable String licensePlate, @RequestBody Moto moto) {
        return ResponseEntity.ok(motoService.update(licensePlate, moto));
    }

    @DeleteMapping("/{licensePlate}")
    public ResponseEntity<Void> delete(@PathVariable String licensePlate) {
        motoService.delete(licensePlate);
        return ResponseEntity.noContent().build();
    }
}

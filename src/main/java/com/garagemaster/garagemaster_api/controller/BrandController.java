package com.garagemaster.garagemaster_api.controller;

import com.garagemaster.garagemaster_api.model.Brand;
import com.garagemaster.garagemaster_api.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable String id) {
        Brand brand = brandService.getById(id);
        return brand != null ? ResponseEntity.ok(brand) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createBrand(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.create(brand));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable String id, @RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.update(id, brand));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

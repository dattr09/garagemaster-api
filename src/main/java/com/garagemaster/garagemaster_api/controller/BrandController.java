package com.garagemaster.garagemaster_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garagemaster.garagemaster_api.model.Brand;
import com.garagemaster.garagemaster_api.service.BrandService;

import lombok.RequiredArgsConstructor;

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

 @PostMapping
public ResponseEntity<?> createBrand(@RequestBody Brand brand) {
    return ResponseEntity.ok(brandService.create(brand));
}

@PutMapping("/{id}")
public ResponseEntity<Brand> update(@PathVariable String id, @RequestBody Brand brand) {
    return ResponseEntity.ok(brandService.update(id, brand));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable String id) {
    brandService.delete(id);
    return ResponseEntity.noContent().build();
}

}

package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Parts;
import com.garagemaster.garagemaster_api.repository.PartsRepository;
import com.garagemaster.garagemaster_api.service.PartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartsServiceImpl implements PartsService {
    private final PartsRepository partsRepository;

    @Override
    public List<Parts> getAll() {
        return partsRepository.findAll();
    }

    @Override
    public Parts getById(String id) {
        return partsRepository.findById(id).orElse(null);
    }

    @Override
    public Parts create(Parts part) {
        return partsRepository.save(part);
    }

    @Override
    public Parts update(String id, Parts part) {
        part.setId(id);
        return partsRepository.save(part);
    }

    @Override
    public void delete(String id) {
        partsRepository.deleteById(id);
    }

    @Override
    public List<Parts> searchByName(String name) {
        return partsRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Parts> getByBrandId(String brandId) {
        return partsRepository.findByBrandId(brandId);
    }

    @Override
    public Parts updateQuantity(String id, int quantityChange) {
        Parts part = getById(id);
        if (part == null) return null;
        int newQuantity = part.getQuantity() + quantityChange;
        part.setQuantity(Math.max(newQuantity, 0));
        return partsRepository.save(part);
    }
}

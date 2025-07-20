package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Moto;
import com.garagemaster.garagemaster_api.repository.MotoRepository;
import com.garagemaster.garagemaster_api.service.MotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoServiceImpl implements MotoService {
    private final MotoRepository motoRepository;

    @Override
    public List<Moto> getAll() {
        return motoRepository.findAll();
    }

    @Override
    public Moto getByLicensePlate(String licensePlate) {
        return motoRepository.findById(licensePlate).orElse(null);
    }

    @Override
    public Moto create(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public Moto update(String licensePlate, Moto moto) {
        moto.setLicensePlate(licensePlate);
        return motoRepository.save(moto);
    }

    @Override
    public void delete(String licensePlate) {
        motoRepository.deleteById(licensePlate);
    }

    @Override
    public List<Moto> getByCustomerId(String customerId) {
        return motoRepository.findByCustomerId(customerId);
    }
}

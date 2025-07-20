package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Moto;
import java.util.List;

public interface MotoService {
    List<Moto> getAll();
    Moto getByLicensePlate(String licensePlate);
    Moto create(Moto moto);
    Moto update(String licensePlate, Moto moto);
    void delete(String licensePlate);
    List<Moto> getByCustomerId(String customerId);
}

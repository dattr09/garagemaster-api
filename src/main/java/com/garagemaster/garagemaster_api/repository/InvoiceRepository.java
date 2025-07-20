package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);
}

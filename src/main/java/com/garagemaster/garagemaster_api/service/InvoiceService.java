package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Invoice;
import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();
    Invoice getById(String id);
    Invoice create(Invoice invoice);
    void delete(String id);
    List<Invoice> getByCustomerId(String customerId);
}

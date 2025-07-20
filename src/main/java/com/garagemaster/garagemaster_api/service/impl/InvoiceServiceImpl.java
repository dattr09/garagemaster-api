package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Invoice;
import com.garagemaster.garagemaster_api.repository.InvoiceRepository;
import com.garagemaster.garagemaster_api.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getById(String id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void delete(String id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> getByCustomerId(String customerId) {
        return invoiceRepository.findByCustomerId(customerId);
    }
}

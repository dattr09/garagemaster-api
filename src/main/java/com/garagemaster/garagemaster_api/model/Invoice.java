package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String customerId;
    private String customerName;
    private String repairOrderId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String paymentMethod; // Cash | BankTransfer
    private double totalCost;
    private LocalDateTime createdAt = LocalDateTime.now();
}

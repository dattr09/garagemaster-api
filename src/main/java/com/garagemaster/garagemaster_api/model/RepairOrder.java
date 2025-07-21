package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "repairorders")
public class RepairOrder {
    @Id
    private String id;
    private String customerId;
    private String licensePlate;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private double totalCost;
    private String employeeId;
}

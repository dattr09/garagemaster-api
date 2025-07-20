package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "repairorders")
public class RepairOrder {
    @Id
    private String id;
    private String customerId;
    private String licensePlate;
    private String employeeId;
    private String description;
    private double totalCost;
    private String status; // Pending, InProgress, Completed, Cancelled
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

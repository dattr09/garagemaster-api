package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String customerId;
    private List<OrderItem> items;
    private LocalDateTime createdAt;
    private String status; // Pending, Completed, Cancelled, etc.
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class OrderItem {
    private String partId;
    private String partName;
    private int quantity;
    private double price;
}

package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private String customerId;
    private String customerName;
    private String phone;
    private String address;
    private String note;
    private List<OrderItem> items;
    private double total;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}

@Data
class OrderItem {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String image;
}

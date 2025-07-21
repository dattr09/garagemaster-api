package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "parts")
public class Parts {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;
    private double buyPrice;
    private double empPrice;
    private String unit;
    private int limitStock;
    private String brandId;
    private String image;
}

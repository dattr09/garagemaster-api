package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "motos")
public class Moto {
    @Id
    private String licensePlate;

    private String brandId;
    private String model;
    private String customerId;
    private LocalDateTime dateOfSent;
    private String notes;
}

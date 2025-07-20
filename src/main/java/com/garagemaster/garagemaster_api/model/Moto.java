package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "motos")
public class Moto {
    @Id
    private String licensePlate; // Biển số là khóa chính

    private String brandId;
    private String model;
    private String customerId;
    private LocalDateTime dateOfSent;
    private String notes;
}

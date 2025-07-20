package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "repairdetails")
public class RepairDetail {
    @Id
    private String id;
    private String repairOrderId; // Liên kết đến RepairOrder
    private String partId;        // Liên kết đến Parts
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}

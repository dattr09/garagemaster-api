package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "repairdetails")
public class RepairDetail {
    @Id
    private String id;
    private String repairOrderId;
    private String partId;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}

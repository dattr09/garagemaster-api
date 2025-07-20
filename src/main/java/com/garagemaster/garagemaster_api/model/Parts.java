package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "parts")
public class Parts {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;      // Giá bán cho khách
    private double buyPrice;   // Giá nhập vào
    private double empPrice;   // Giá bán cho nhân viên
    private String unit;       // Đơn vị: cái, bộ, lít,...
    private int limitStock;    // Giới hạn tồn kho tối thiểu
    private String brandId;    // Tham chiếu tới Brand
    private String image;      // Link ảnh phụ tùng
}

package com.example.challenge4.dto.orderDetail;

import lombok.Data;

@Data
public class OrderDetailReportDto {
    private String username;
    private String productName;
    private String price;
    private String quantity;
    private String totalPrice;
    private String orderId;
    private String merchantName;
}

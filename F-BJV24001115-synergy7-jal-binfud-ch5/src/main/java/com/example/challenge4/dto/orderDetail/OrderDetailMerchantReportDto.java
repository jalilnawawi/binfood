package com.example.challenge4.dto.orderDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDetailMerchantReportDto {
    @JsonProperty("merchant_name")
    String merchantName;

    @JsonProperty("order_time")
    LocalDate orderTime;

    @JsonProperty("product_name")
    String productName;

    double totalPrice;
}

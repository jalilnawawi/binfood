package com.example.challenge4.dto.merchant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MerchantReportDto {
    @JsonProperty("merchant_name")
    String merchantName;

    @JsonProperty("order_time")
    Date orderTime;

    @JsonProperty("product_name")
    String productName;

    int quantity;
    int price;
    double totalPrice;
}

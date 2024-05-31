package com.example.challenge4.dto.orderDetail;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDetailRequestMerchantReportDto {
    UUID merchantId;
    LocalDate startDate;
    LocalDate endDate;
}

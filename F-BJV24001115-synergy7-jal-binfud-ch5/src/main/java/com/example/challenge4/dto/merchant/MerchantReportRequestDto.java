package com.example.challenge4.dto.merchant;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MerchantReportRequestDto {
    UUID merchantId;
    LocalDate startDate;
    LocalDate endDate;
}

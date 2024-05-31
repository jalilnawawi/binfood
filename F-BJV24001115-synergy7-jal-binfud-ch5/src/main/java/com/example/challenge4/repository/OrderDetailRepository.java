package com.example.challenge4.repository;

import com.example.challenge4.controller.OrderDetailController;
import com.example.challenge4.dto.orderDetail.OrderDetailMerchantReportDto;
import com.example.challenge4.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
    Optional<OrderDetail> findByMerchantId(UUID merchantId);
}

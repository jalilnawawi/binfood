package com.example.challenge4.repository;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

}

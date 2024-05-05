package com.example.challenge4.repository;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> getProductByName(String name);
    List<Product> findProductByMerchant(Merchant merchant);
}

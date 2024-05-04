package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.model.Product;

import java.util.Optional;

public interface OrderDetailService {
    OrderDetail create(OrderDetail orderDetail);

    Product selectProduct(int selectProduct, Merchant merchant);

    int quantity();

}

package com.example.challenge4.service;

import com.example.challenge4.controller.OrderController;
import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.repository.MerchantRepository;
import com.example.challenge4.repository.OrderDetailRepository;
import com.example.challenge4.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderController orderController;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    ProductService productService;


    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        orderDetail = orderDetailRepository.save(orderDetail);
        return orderDetail;
    }

}

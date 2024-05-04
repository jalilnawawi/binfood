package com.example.challenge4.service;

import com.example.challenge4.model.Order;
import com.example.challenge4.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        order = orderRepository.save(order);
        return order;
    }
}

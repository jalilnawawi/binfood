package com.example.challenge4.controller;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Order;
import com.example.challenge4.model.Users;
import com.example.challenge4.service.MerchantService;
import com.example.challenge4.service.OrderService;
import com.example.challenge4.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class OrderController {
    @Autowired
    UsersService usersService;

    @Autowired
    UserController userController;

    @Autowired
    MerchantService merchantService;

    @Autowired
    MerchantController merchantController;

    @Autowired
    OrderService orderService;

    Users user;
    Merchant merchant;

    public void mainMenu(){
        createOrder();
    }

    public Order createOrder(){
        Order order = new Order();
        order.setOrderTime(LocalDate.now());

        userController.showUsers();
        user = usersService.getUserByUsername(userController.getUserByUsername());
        order.setUsers(user);

        orderService.create(order);
        System.out.println("Selamat berbelanja " + order.getUsers().getUsername());

        return order;
    }
}

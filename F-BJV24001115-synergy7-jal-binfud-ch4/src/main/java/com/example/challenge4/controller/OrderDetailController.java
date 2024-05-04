package com.example.challenge4.controller;

import com.example.challenge4.model.*;
import com.example.challenge4.service.*;
import com.example.challenge4.view.OrderDetailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

@Component
@Slf4j
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    UserController userController;

    @Autowired
    UsersService usersService;

    @Autowired
    MerchantController merchantController;

    @Autowired
    MerchantService merchantService;

    @Autowired
    OrderController orderController;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    Map<Long, OrderDetail> orderDetailMap = new TreeMap();

    @Autowired
    OrderDetailView orderDetailView;

    public Long generateIdForMap(){
        Random random = new Random();
        Long randomId = random.nextLong();
        return randomId;
    }

    public void mainMenu(){
        selectProduct();
    }

    public void selectProduct(){
        Scanner scanner = new Scanner(System.in);

        //user
        userController.showUsers();
        System.out.println("input username => ");
        String username = scanner.nextLine();
        Users user = usersService.getUserByUsername(username);

        //merchant
        merchantController.showMerchantWithStatusOpen();
        System.out.println("input merchant name => ");
        String merchantName = scanner.nextLine();
        Merchant merchant = merchantService.getMerchantByName(merchantName);

        //order
        Order order = new Order();
        order.setOrderTime(LocalDate.now());
        order.setUsers(user);
        order.setDestinationAddress(merchant.getLocation());
        orderService.create(order);

        OrderDetail orderDetail = new OrderDetail();

        orderDetailView.displaySelectProduct();
        Product product = new Product();

        product.setMerchant(merchant);
        int selectProduct = scanner.nextInt();
        if (selectProduct == 1){
            product = productService.getProductByName("Nasi Goreng");
        }

        if (product != null){
            int inputQty = inputQty();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(inputQty);
            orderDetailService.create(orderDetail);
            orderDetailMap.put(generateIdForMap(), orderDetail);
        }
        orderDetailMap.forEach((aLong, orderDetail1) -> System.out.println(
                orderDetail1.getProduct().getName() + " | " + orderDetail1.getProduct().getPrice()
                + " | " + orderDetail1.getProduct().getMerchant().getName()
        ));
    }

    public int inputQty(){
        System.out.println("Berapa jumlah pesanan anda => ");
        Scanner scanner = new Scanner(System.in);
        int inputQty = scanner.nextInt();
        return inputQty;
    }
}

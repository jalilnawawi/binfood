package org.example.controller;

import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.view.OrderView;

import java.util.Scanner;

public class OrderController {
    OrderView orderView = new OrderView();
    public void orderController(){
        selectProduct();
        getSelectedProduct();
    }
    public void getSelectedProduct(){
        OrderService orderService = new OrderServiceImpl();
        orderService.confirmPay();
        orderService.confirmPaySelection();
    }
    public void selectProduct(){
        Scanner scanner = new Scanner(System.in);

        orderView.displaySelectProduct();
        int selectProduct = scanner.nextInt();

        OrderService orderService = new OrderServiceImpl();
        orderService.selectProduct(selectProduct);
    }

    public int inputQty(){
        orderView.displayInputQuantity();
        Scanner scanner = new Scanner(System.in);
        int inputQty = scanner.nextInt();
        return inputQty;
    }

}

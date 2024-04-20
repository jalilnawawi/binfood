package org.example.service;


import org.example.Data;
import org.example.controller.OrderController;
import org.example.model.Order;
import org.example.model.OrderDetail;
import org.example.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    Map<String, OrderDetail> orderDetailMap;
    OrderDetail orderDetail;
    OrderService orderService;
    OrderController orderController;

    @BeforeEach
    void setUp(){
        orderDetailMap = Data.orderDetailMap;
        orderDetail = new OrderDetail();
        orderService = new OrderServiceImpl();
        orderController = new OrderController();
    }


    @Test
    void generateId() {
        String generateId = orderService.generateId();

        Assertions.assertNotNull(generateId);
        assertTrue(generateId.matches(".*"));
    }

    @Test
    void getProduct() {
        Product testProduct = new Product()
                .setProductId(1)
                .setProductName("test");

        Data.productMap.put(testProduct.getProductId(), testProduct);

        Product actualProduct = orderService.getProduct(1);

        assertEquals(testProduct.getProductId(),actualProduct.getProductId());
    }

    @Test
    void selectProduct() {

    }

    @Test
    void confirmPay() {
    }

    @Test
    void confirmPaySelection() {
    }

    @Test
    void printReceipt() {
    }

    @Test
    void totalQty() {
        OrderDetail orderDetail1 = new OrderDetail().setQuantity(1);
        OrderDetail orderDetail2 = new OrderDetail().setQuantity(2);

        orderDetailMap.put("1", orderDetail1);
        orderDetailMap.put("2", orderDetail2);

        assertEquals(3,orderService.totalQty());
    }

    @Test
    void totalPrice() {
        OrderDetail orderDetail1 = new OrderDetail()
                .setProduct(new Product()
                        .setProductName("A")
                        .setPrice(1000)
                )
                .setQuantity(2);
        OrderDetail orderDetail2 = new OrderDetail()
                .setProduct(new Product()
                        .setProductName("B")
                        .setPrice(2000)
                )
                .setQuantity(2);
        orderDetailMap.put("1", orderDetail1);
        orderDetailMap.put("2", orderDetail2);

        int result = orderService.totalPrice();
        System.out.println(result);

    }
}

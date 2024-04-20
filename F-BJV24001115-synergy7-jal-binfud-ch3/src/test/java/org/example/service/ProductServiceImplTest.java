package org.example.service;

import org.example.Data;
import org.example.model.OrderDetail;
import org.example.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    ProductService productService;

    @BeforeEach
    void setUp(){

        productService = new ProductServiceImpl();
    }
    @Test
    void getProduct() {


        TreeMap<Integer, Product> expectedProductMap = Data.productMap;

        TreeMap<Integer, Product> actualProductMap = productService.getProduct();

        Assertions.assertEquals(expectedProductMap,actualProductMap);

    }
}
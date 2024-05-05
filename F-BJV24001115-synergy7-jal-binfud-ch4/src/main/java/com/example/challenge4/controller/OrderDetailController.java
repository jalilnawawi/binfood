package com.example.challenge4.controller;

import com.example.challenge4.model.*;
import com.example.challenge4.service.*;
import com.example.challenge4.view.OrderDetailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

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

    Users user;
    Order order;
    Merchant merchant;
    Product selectedProduct;
    OrderDetail orderDetail = new OrderDetail();


    public Long generateIdForMap(){
        Random random = new Random();
        Long randomId = random.nextLong();
        return randomId;
    }

    public void mainMenu(){
        order = orderController.createOrder();
        merchantController.showMerchantWithStatusOpen();
        merchant = merchantController.showMerchantByInputName();

        selectedProduct = selectProduct();
        int quantity = inputQty();

        orderDetail.setOrder(order);
        orderDetail.setProduct(selectedProduct);
        orderDetail.setQuantity(quantity);
        orderDetailMap.put(generateIdForMap(), orderDetail);
        orderDetailMap.forEach((aLong, orderDetail1) -> System.out.println(
                orderDetail1.getProduct().getName() + " | "
                + orderDetail1.getProduct().getPrice() + " | "
                + orderDetail1.getQuantity()
        ));
    }

    public Product selectProduct(){
        System.out.println("Berikut daftar menu " + merchant.getName());
        List<Product> productList = productService.showProductFromSelectedMerchant(merchant);
        productList.forEach(product -> System.out.println(
                product.getName() + " | " + product.getPrice()
        ));

        orderDetailView.displaySelectProduct();
        Scanner select = new Scanner(System.in);
        String inputProductName = select.nextLine();
        selectedProduct = productService.getProductByName(inputProductName);

        return selectedProduct;
    }

    public int inputQty(){
        System.out.println("Berapa jumlah pesanan anda => ");
        Scanner scanner = new Scanner(System.in);
        int inputQty = scanner.nextInt();
        return inputQty;
    }
}

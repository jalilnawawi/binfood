package com.example.challenge4.controller;

import com.example.challenge4.model.*;
import com.example.challenge4.service.ProductService;
import com.example.challenge4.service.UsersService;
import com.example.challenge4.view.OrderDetailView;
import com.example.challenge4.view.UsersView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
@Slf4j
public class MainController {
    @Autowired
    MerchantController merchantController;

    @Autowired
    ProductController productController;

    @Autowired
    UserController userController;

    @Autowired
    UsersService usersService;

    @Autowired
    OrderController orderController;

    @Autowired
    OrderDetailController orderDetailController;

    @Autowired
    ProductService productService;

    UsersView usersView = new UsersView();
    OrderDetailView orderDetailView = new OrderDetailView();

    Users user;
    Merchant merchant;
    Product selectedProduct;
    Map<Long, OrderDetail> orderDetailMap = new HashMap<>();

    public void mainController(){
//        userController.mainMenu();
//        orderController.mainMenu();
//        merchantController.mainMenu();
//        productController.mainMenu();
//        orderDetailController.mainMenu();
        orderFlowController();

    }

    public void orderFlowController(){
        //halaman user
        Scanner scanner = new Scanner(System.in);
        usersView.userServiceDisplay();
        System.out.println("Pilih opsi => ");
        int option = scanner.nextInt();
        if (option == 1){
            userController.showUsers();
            String username = userController.getUserByUsername();
            user = usersService.getUserByUsername(username);
        }
        else if (option == 2){
            userController.createUser();
        } else if (option == 3) {
            userController.showUsers();
          userController.updateUsers();
        } else if (option == 4) {
           userController.showUsers();
           userController.deleteUser();
        }

        //halaman order
        Order order = new Order();
        merchantController.showMerchantWithStatusOpen();
        System.out.println("Silahkan pilih resto = ");
        merchant = merchantController.showMerchantByInputName();
        order.setOrderTime(LocalDate.now());
        order.setUsers(user);
        order.setDestinationAddress(merchant.getLocation());

        //halaman order detail
        OrderDetail orderDetail = new OrderDetail();
        orderDetailView.displaySelectProduct();
        Scanner select = new Scanner(System.in);
        int selectProduct = select.nextInt();
        selectedProduct.setMerchant(merchant);
        if (selectProduct == 1){
            selectedProduct = productService.getProductByName("Nasi Goreng");
        }

        orderDetailView.displayInputQuantity();
        Scanner inputQuantity = new Scanner(System.in);
        int quantity = inputQuantity.nextInt();
        orderDetail.setOrder(order);
        orderDetail.setProduct(selectedProduct);
        orderDetail.setQuantity(quantity);
        orderDetailMap.put(orderDetailController.generateIdForMap(), orderDetail);

        orderDetailMap.forEach((aLong, orderDetail1) -> System.out.println(
                orderDetail1.getProduct().getName() + " | " + orderDetail1.getProduct().getMerchant()
        ));
    }
}

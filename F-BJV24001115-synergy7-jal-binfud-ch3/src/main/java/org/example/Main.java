package org.example;

import org.example.controller.MerchantController;
import org.example.controller.OrderController;
import org.example.controller.ProductController;
import org.example.controller.UserController;
import org.example.model.Merchant;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.userLogin();

        MerchantController merchantController = new MerchantController();
        merchantController.merchantController();

        ProductController productController = new ProductController();
        productController.mainMenu();

        OrderController orderController = new OrderController();
        orderController.orderController();
    }
}
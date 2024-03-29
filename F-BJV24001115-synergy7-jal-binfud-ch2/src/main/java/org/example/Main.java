package org.example;

import org.example.controller.MenuController;
import org.example.controller.OrderController;
import org.example.model.Menu;
import org.example.model.OrderedItem;
import org.example.view.OrderView;

import java.util.ArrayList;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Data.initiateData();
        MenuController menuController = new MenuController();
        menuController.displayMenu();

        OrderController orderController = new OrderController();
        orderController.displayMenuSelection();

    }
}
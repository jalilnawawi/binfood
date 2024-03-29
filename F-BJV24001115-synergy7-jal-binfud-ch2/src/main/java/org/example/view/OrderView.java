package org.example.view;

import lombok.NoArgsConstructor;
import org.example.Data;
import org.example.controller.OrderController;
import org.example.model.Menu;
import org.example.model.OrderedItem;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;

import java.sql.SQLOutput;
import java.util.*;

import static org.example.Data.menuMap;


public class OrderView {
    public void menuSelection(){
        System.out.print("=> ");
        Scanner inputMenuId = new Scanner(System.in);
        int selectMenu = inputMenuId.nextInt();

        System.out.print("Qty => ");
        Scanner inputQty = new Scanner(System.in);
        int qty = inputQty.nextInt();

        OrderController orderController = new OrderController();
        orderController.menuSelection(selectMenu, qty);
    }
}


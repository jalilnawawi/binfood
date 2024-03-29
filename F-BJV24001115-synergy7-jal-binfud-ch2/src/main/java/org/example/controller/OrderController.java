package org.example.controller;

import org.example.model.Menu;
import org.example.model.Order;
import org.example.model.OrderedItem;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.view.OrderView;

import java.time.LocalDateTime;
import java.util.*;

public class OrderController {
    private Menu menu;
    Map<Integer, OrderedItem> orderedItemMap = new HashMap<>();

    public void displayMenuSelection(){
        OrderView orderView = new OrderView();
        orderView.menuSelection();
    }
    public void menuSelection(int selectedMenu, int qty){
        OrderService orderService = new OrderServiceImpl();

        if (selectedMenu >= 1 && selectedMenu <= 5 && qty != 0){
            Menu menu1 = orderService.getMenu(selectedMenu);
            OrderedItem oi1 = new OrderedItem();
            oi1.setMenu(menu1);
            oi1.setQty(qty);
            orderedItemMap.put(1, oi1);
            for (Integer key : orderedItemMap.keySet()){
                System.out.println(
                        orderedItemMap.get(key).getMenu().getName()
                        + " | "
                        + orderedItemMap.get(key).getMenu().getPrice()
                        + " | "
                        + orderedItemMap.get(key).getQty()
                );
            }
        }

    }

}


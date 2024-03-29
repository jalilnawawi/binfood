package org.example.controller;

import org.example.model.Menu;
import org.example.model.OrderedItem;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.view.OrderView;

import java.util.*;

public class OrderController {
    private Menu menu;
    private Map<Integer, OrderedItem> orderedItemMap;

    public void displayMainMenu(){
        OrderView orderView = new OrderView();
        orderView.menuSelection();
        orderView.menuQty();
        orderView.confirmPay();
        orderView.optionLast();
    }
    public void menuSelection(int selectedMenu, Map<Integer, OrderedItem> orderedItemMap, List<OrderedItem> orderList){
        if (selectedMenu >= 1 && selectedMenu <= 5){
            OrderService orderService = new OrderServiceImpl();
            Menu menuSelect = orderService.getMenu(selectedMenu);
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setMenu(menuSelect);
            orderedItemMap.put(1, orderedItem);

            orderList.add(orderedItem);

        } else if (selectedMenu == 99) {
            System.out.println("konfirmasi dan bayar");
        } else if (selectedMenu == 0){
            System.exit(1);
        }


    }

    public void menuQty(Map<Integer, OrderedItem> orderedItemMap, int qty){
        if (qty != 0){
            for (Integer key : orderedItemMap.keySet()){
                orderedItemMap.get(key).setQty(qty);
            }
        } else {
            System.out.println("========================");
            System.out.println("Minimal 1 jumlah pesanan!");
            System.out.println("========================");
            MenuController menuController = new MenuController();
            menuController.displayMenu();
            displayMainMenu();
        }
    }

    public void displayConfirmPay(List<OrderedItem> orderList){
        System.out.println();
        System.out.println("=====================\n"
                + "Konfirmasi dan Bayar\n"
                + "=====================\n"
        );
        for (OrderedItem item : orderList){
            System.out.println(item.getMenu().getName()
                            + " | "
                            + item.getQty()
                            + " | "
                            + item.getMenu().getPrice()
            );
        }

        int totalQty = 0;
        int totalPrice = 0;
        int total = 0;

        for (OrderedItem calculate : orderList){
            totalQty += calculate.getQty();
            totalPrice = calculate.getMenu().getPrice() * calculate.getQty();
            total += totalPrice;
        }
        System.out.println("-------------------------+");
        System.out.println("Total"+ "\t" + totalQty + "|" + total + "\n");
    }

    public void optionLast(int selectOption){
        if (selectOption == 1){
            System.out.println("Bayar!!");
        } else if (selectOption == 2) {
            MenuController menuController = new MenuController();
            menuController.displayMenu();
            displayMainMenu();
        } else if (selectOption == 0) {
            System.exit(1);
        }
    }

}


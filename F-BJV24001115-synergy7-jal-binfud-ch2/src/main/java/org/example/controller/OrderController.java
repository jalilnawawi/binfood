package org.example.controller;

import org.example.model.Menu;
import org.example.model.Order;
import org.example.model.OrderedItem;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.view.OrderView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
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
    public void menuSelection(int selectedMenu, Map<Integer, OrderedItem> orderedItemMap,
                              List<OrderedItem> orderedItemList, List<Order> orderList){
        if (selectedMenu >= 1 && selectedMenu <= 5){
            OrderService orderService = new OrderServiceImpl();
            Menu menuSelect = orderService.getMenu(selectedMenu);
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setMenu(menuSelect);
            orderedItemMap.put(1, orderedItem);

            orderedItemList.add(orderedItem);

            OrderService generateOrderId = new OrderServiceImpl();
            Long orderId = generateOrderId.generateOrderId();

            Order order = new Order()
                    .setId(orderId)
                    .setOrderList(orderedItemList)
                    .setCreatedTime(LocalDateTime.now());

            orderList.add(order);

        } else if (selectedMenu == 99) {
            if (orderedItemList.isEmpty()){
                System.out.println("=========================\n"
                        + "Minimal 1 jumlah pesanan!\n"
                        + "=========================\n");
                throw new RuntimeException();
            }
            OrderView orderView = new OrderView();
            orderView.confirmPay();
            orderView.optionLast();
            System.exit(1);
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
            OrderView orderView = new OrderView();
            orderView.menuQty();
        }
    }

    public void displayConfirmPay(List<OrderedItem> orderedItemList){
        System.out.println();
        System.out.println("=====================\n"
                + "Konfirmasi dan Bayar\n"
                + "=====================\n"
        );
        for (OrderedItem item : orderedItemList){
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

        for (OrderedItem calculate : orderedItemList){
            totalQty += calculate.getQty();
            totalPrice = calculate.getMenu().getPrice() * calculate.getQty();
            total += totalPrice;
        }

        System.out.println("-------------------------+");
        System.out.println("Total"+ "\t" + totalQty + "|" + total + "\n");
    }

    public void optionLast(int selectOption, List<OrderedItem> orderedItemList, List<Order> orderList){
        if (selectOption == 1){
            printReceipt(orderedItemList, orderList);
        } else if (selectOption == 2) {
            MenuController menuController = new MenuController();
            menuController.displayMenu();
            displayMainMenu();
        } else if (selectOption == 0) {
            System.exit(1);
        }
    }

    public void printReceipt(List<OrderedItem> orderedItemList, List<Order> orderList){
        System.out.println("Receipt Printed");
        try {
            FileWriter writer = new FileWriter("receipt.txt");
            BufferedWriter bwr = new BufferedWriter(writer);
            for (Order order : orderList){
                bwr.write("Order Id : " + order.getId() + "\n");
                bwr.write("Order Date : " + order.getCreatedTime() + "\n");
            }
            bwr.write("===============================\n" +
                    "BinarFud\n" +
                    "===============================\n");
            bwr.write("Terima kasih sudah memesan \ndi BinarFud\n" + "\n");
            bwr.write("Dibawah ini adalah pesanan anda\n" + "\n");

            for (OrderedItem item : orderedItemList){
                bwr.write(
                        item.getMenu().getName()
                        + " \t "
                        + item.getQty()
                        + " \t "
                        + item.getMenu().getPrice()
                        + "\n"
                );
            }

            int totalQty = 0;
            int totalPrice = 0;
            int total = 0;

            for (OrderedItem calculate : orderedItemList){
                totalQty += calculate.getQty();
                totalPrice = calculate.getMenu().getPrice() * calculate.getQty();
                total += totalPrice;
            }
            bwr.write("------------------------------+" + "\n" +
                    "Total " + "\t" + totalQty + "\t" + total + "\n");
            bwr.write("\n");
            bwr.write("Pembayaran : BinarCash" + "\n");
            bwr.write("\n");
            bwr.write("===============================\n" +
                    "Simpan struk ini sebagai \nbukti pembayaran\n" +
                    "===============================");
            bwr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}


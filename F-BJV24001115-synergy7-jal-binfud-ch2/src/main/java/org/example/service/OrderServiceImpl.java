package org.example.service;

import org.example.Data;
import org.example.model.Menu;
import org.example.model.Order;
import org.example.model.OrderedItem;

import java.util.List;
import java.util.Random;

public class OrderServiceImpl implements OrderService{
    @Override
    public Menu getMenu(int id) {
        return Data.menuMap.get(id);
    }

    @Override
    public int getTotalQty(List<OrderedItem> orderList) {
        int totalQty = 0;
        for (OrderedItem calculate : orderList){
            totalQty += calculate.getQty();
        }
        return 0;
    }

    @Override
    public int getTotalPrice(List<OrderedItem> orderList) {
        int totalPrice = 0;
        int total = 0;
        for (OrderedItem calculate : orderList){
            totalPrice = calculate.getMenu().getPrice() * calculate.getQty();
            total += totalPrice;
        }
        return 0;
    }

    @Override
    public OrderedItem getOrderedItem(int id) {
        return Data.orderedItemMap.get(id);
    }

    @Override
    public Long generateOrderId() {
        Random random = new Random();
        long orderId = random.nextLong();
        return orderId;
    }

    @Override
    public List<Order> getOrderList() {
        return Data.orderList;
    }

    @Override
    public void printReceipt() {
        printReceipt();
    }
}

package org.example.service;

import org.example.model.Menu;
import org.example.model.Order;
import org.example.model.OrderedItem;

import java.util.List;

public interface OrderService {
    Menu getMenu(int id);
    int getTotalQty(List<OrderedItem> orderList);

    int getTotalPrice(List<OrderedItem> orderList);

    OrderedItem getOrderedItem(int id);

    Long generateOrderId();

    List<Order> getOrderList();

    void printReceipt();
}

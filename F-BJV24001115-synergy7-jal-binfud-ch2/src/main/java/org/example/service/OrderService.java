package org.example.service;

import org.example.model.Menu;
import org.example.model.OrderedItem;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Menu getMenu(int id);
    int getTotalQty(Map<Integer, OrderedItem> orderedItemMap);

    int getTotalPrice(Map<Integer, OrderedItem> orderedItemMap);

    OrderedItem getOrderedItem(int id);
}

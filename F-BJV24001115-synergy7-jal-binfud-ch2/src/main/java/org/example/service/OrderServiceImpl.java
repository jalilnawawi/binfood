package org.example.service;

import org.example.Data;
import org.example.model.Menu;
import org.example.model.OrderedItem;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService{
    @Override
    public Menu getMenu(int id) {
        return Data.menuMap.get(id);
    }
}

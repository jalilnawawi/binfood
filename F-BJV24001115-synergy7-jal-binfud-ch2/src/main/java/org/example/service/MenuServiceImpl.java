package org.example.service;

import org.example.Data;
import org.example.model.Menu;

import java.util.Map;

public class MenuServiceImpl implements MenuService{
    @Override
    public Map<Integer, Menu> getMenuList() {
        return Data.menuMap;
    }
}

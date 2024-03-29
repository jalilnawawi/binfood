package org.example.service;

import org.example.model.Menu;

import java.util.Map;

public interface MenuService {
    Map<Integer, Menu> getMenuList();
}

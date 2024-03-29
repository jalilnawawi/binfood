package org.example.controller;

import org.example.model.Menu;
import org.example.service.MenuService;
import org.example.service.MenuServiceImpl;
import org.example.view.MenuView;

import java.util.Map;

public class MenuController {
    public void displayMenu(){
        MenuService menuService = new MenuServiceImpl();
        Map<Integer, Menu> menuMap = menuService.getMenuList();

        MenuView menuView = new MenuView();
        menuView.displayMenu(menuMap);
    }
}

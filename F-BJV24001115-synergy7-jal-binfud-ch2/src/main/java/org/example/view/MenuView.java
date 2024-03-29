package org.example.view;

import org.example.Data;
import org.example.model.Menu;

import java.util.Map;

public class MenuView {
    public void displayMenu(Map<Integer, Menu> menuMap){
        System.out.println("==========================");
        System.out.println("Selamat datang di Binarfud");
        System.out.println("==========================\n");

        System.out.println("Silahkan pilih makanan :");
        for (Integer key : Data.menuMap.keySet()){
            System.out.println(
                    menuMap.get(key).getId() + "."
                    + menuMap.get(key).getName() + " | "
                    + menuMap.get(key).getPrice()
            );
        }

    }
}

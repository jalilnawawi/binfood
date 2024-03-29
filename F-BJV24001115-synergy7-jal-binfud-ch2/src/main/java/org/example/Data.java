package org.example;

import org.example.model.Menu;
import org.example.model.OrderedItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public static Map<Integer, Menu> menuMap = new HashMap<>();

    public static void initiateData(){
        Menu menu1 = new Menu()
                .setId(1)
                .setName("Nasi Goreng")
                .setPrice(15000);

        Menu menu2 = new Menu()
                .setId(2)
                .setName("Mie Goreng")
                .setPrice(13000);

        Menu menu3 = new Menu()
                .setId(3)
                .setName("Nasi Ayam")
                .setPrice(18000);

        Menu menu4 = new Menu()
                .setId(4)
                .setName("Es Teh Manis")
                .setPrice(3000);

        Menu menu5 = new Menu()
                .setId(5)
                .setName("Es Jeruk")
                .setPrice(5000);

        menuMap.put(menu1.getId(), menu1);
        menuMap.put(menu2.getId(), menu2);
        menuMap.put(menu3.getId(), menu3);
        menuMap.put(menu4.getId(), menu4);
        menuMap.put(menu5.getId(), menu5);
    }

}

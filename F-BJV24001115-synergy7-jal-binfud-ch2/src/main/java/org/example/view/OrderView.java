package org.example.view;

import org.example.controller.MenuController;
import org.example.controller.OrderController;

import java.util.*;

import static org.example.Data.orderList;
import static org.example.Data.orderedItemMap;



public class OrderView {
    public void menuSelection(){
        System.out.println();
        System.out.print("Select Item => ");
        Scanner inputItemId = new Scanner(System.in);
        int selectItem = inputItemId.nextInt();

        OrderController orderController = new OrderController();
        orderController.menuSelection(selectItem, orderedItemMap, orderList);

        if (selectItem > 5 && selectItem != 99 && selectItem != 0){
            System.out.println("========================");
            System.out.println("Mohon masukkan input pilihan anda");
            System.out.println("========================");
            System.out.println("(Y) untuk lanjut");
            System.out.println("(n) untuk keluar");

            System.out.print("=> ");
            Scanner input = new Scanner(System.in);
            String option = input.next();

            if (!option.equals("Y") && !option.equals("n")){
                System.exit(1);
            } else {
                MenuController menuController = new MenuController();
                menuController.displayMenu();
                orderController.displayMainMenu();
            }
        }
    }

    public void menuQty(){
        System.out.println();
        System.out.println("=====================\n"
                + "Berapa Pesanan Anda\n"
                + "=====================\n"
        );

        for (Integer key : orderedItemMap.keySet()){
            System.out.println(
                    orderedItemMap.get(key).getMenu().getName()
                            + " | "
                            + orderedItemMap.get(key).getMenu().getPrice()
            );
        }

        System.out.print("Qty => ");
        Scanner menuQty = new Scanner(System.in);
        int qty = menuQty.nextInt();

        OrderController orderController = new OrderController();
        orderController.menuQty(orderedItemMap, qty);
    }

    public void confirmPay(){
        OrderController orderController = new OrderController();
        orderController.displayConfirmPay(orderList);
    }

    public void optionLast(){
        System.out.println("1." + "Konfirmasi dan Bayar");
        System.out.println("2." + "Kembali ke Menu Utama");
        System.out.println("0." + "Keluar Aplikasi");

        System.out.print("=> ");
        Scanner optionMenu = new Scanner(System.in);
        int selectMenu = optionMenu.nextInt();

        OrderController orderController = new OrderController();
        orderController.optionLast(selectMenu);
    }
}


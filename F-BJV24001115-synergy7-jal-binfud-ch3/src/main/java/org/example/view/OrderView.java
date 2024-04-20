package org.example.view;

import org.example.controller.OrderController;
import org.example.model.OrderDetail;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.example.Data.orderDetailMap;

public class OrderView {
    public void displaySelectProduct(){
        System.out.print("Select your Product => ");
    }

    public void displayInputQuantity(){
        System.out.print(
                "Berapa pesanan anda => "
        );
    }

    public void displayConfirmPayHeader(){
        System.out.println();
        System.out.println("=====================\n"
                + "Konfirmasi dan Bayar\n"
                + "=====================\n"
        );
    }

    public void displayConfirmPaySelection(){
        System.out.println(
                "1. " + "Konfirmasi dan Bayar\n"
                + "2. " + "Kembali ke menu utama\n"
                + "3. " + "Keluar aplikasi"
        );
        System.out.print(
                "Select option => "
        );
    }

    public void displayOutsideExistingMenu(){
        System.out.println(
                "============================\n"
                + "Mohon masukkan input\n"
                + "pilihan anda\n"
                + "============================\n"
        );
        System.out.println(
                "(Y) untuk lanjut\n"
                + "(n) untuk keluar"
        );
        System.out.print(
                "Select option => "
        );
    }
    public void displayOutsideExistingOption(){
        System.out.println(
                "============================\n"
                        + "Mohon input nomor menu\n"
                        + "sesuai yang tertera\n"
                        + "============================\n"
        );
        System.out.println(
                "(Y) untuk lanjut\n"
                        + "(n) untuk keluar"
        );
        System.out.print(
                "Select option => "
        );
    }
}

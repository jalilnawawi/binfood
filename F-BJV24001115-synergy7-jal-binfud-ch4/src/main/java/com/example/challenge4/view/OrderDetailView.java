package com.example.challenge4.view;

import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.model.Product;
import com.example.challenge4.repository.ProductRepository;
import com.example.challenge4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component
public class OrderDetailView {
    public void displaySelectProduct(){
        System.out.print("Pilih Menu => ");
    }

    public void displayInputQuantity(){
        System.out.print(
                "Berapa pesanan anda => "
        );
    }

    public void displayConfirmPayHeader() {
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

}

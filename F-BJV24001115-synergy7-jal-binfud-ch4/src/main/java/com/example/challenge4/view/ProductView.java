package com.example.challenge4.view;

public class ProductView {
    public void displayInputNama(){
        System.out.print("nama : ");
    }
    public void displayInputHarga(){
        System.out.print("harga : ");
    }

    public void displayHeader(){
        System.out.println(
                "Nama Merchant" + " | "
                + "Menu" + " | "
                + "Harga"
        );
    }
}

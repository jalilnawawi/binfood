package com.example.challenge4.view;

import com.example.challenge4.model.OrderDetail;

import java.util.List;

public class OrderDetailView {
    List<OrderDetail> orderDetailList;
    public void displaySelectProduct(){
        System.out.println(
                "1. " + "Nasi Goreng " + " | " + "15.000\n" +
                "2. " + "Mie Goreng " + " | " + "13.000\n" +
                "3. " + "Nasi + Ayam " + " | " + "18.000\n" +
                "4. " + "Es Teh " + " | " + "3.000\n" +
                "5. " + "Es Jeruk " + " | " + "5.000\n"
        );
        System.out.println("Pilih Menu => ");
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

    public void displayConfirmPay() {
        orderDetailList.forEach(orderDetail -> System.out.println(
                orderDetail.getProduct().getName() + " | " +
                        orderDetail.getQuantity() + " | " +
                        orderDetail.getProduct().getPrice()
        ));
    }
}

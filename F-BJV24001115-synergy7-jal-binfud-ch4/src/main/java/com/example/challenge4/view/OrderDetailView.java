package com.example.challenge4.view;

import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.model.Product;
import com.example.challenge4.repository.ProductRepository;
import com.example.challenge4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class OrderDetailView {
    @Autowired
    ProductService productService;

    List<OrderDetail> orderDetailList;
    public void displaySelectProduct(){
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

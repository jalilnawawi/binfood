package org.example.view;

import org.example.model.Merchant;
import org.example.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ProductView {
    public void displayProduct(TreeMap<Integer, Product> productMap){
        System.out.println(
                "\n" +
                "================================\n"
                + "Selamat datang di BinarFud\n"
                + "================================"
        );
//        for (Integer key : productMap.keySet()){
//            displayProduct(productMap.get(key));
//        }

        productMap.forEach((key,value) -> displayProduct(productMap.get(key)));

        System.out.println(
                "99. " + "Pesan dan Bayar\n"
                + "0. " + "Keluar aplikasi"
        );
    }

    public void displayProduct(Product product){

        System.out.println(
                product.getProductId() + "." + " "
                + product.getProductName() + "\t" + " | "
                + product.getPrice()
                );
    }
}

package org.example;

import org.example.model.*;

import java.util.*;

public class Data {
    public static List<Users> usersList = new ArrayList<>();
    public static List<Merchant> merchantList = new ArrayList<>();
    public static TreeMap<Integer, Product> productMap = new TreeMap<>();
    public static Map<String, Order> orderMap = new HashMap<>();
    public static Map<String, OrderDetail> orderDetailMap = new HashMap<>();

    public static void initiateUsers(){
        Users user1 = new Users()
                .setUserId("U1")
                .setUserName("User1")
                .setEmail("user1@gmail.com")
                .setPassword("user1");

        Users user2 = new Users()
                .setUserId("U2")
                .setUserName("User2")
                .setEmail("user2@gmail.com")
                .setPassword("user2");

        Users user3 = new Users()
                .setUserId("U3")
                .setUserName("User3")
                .setEmail("user3@gmail.com")
                .setPassword("user3");

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
    }

    public static void initiateMerchant(){
        Merchant warteg1 = new Merchant()
                .setMerchantId(1)
                .setMerchantName("Warteg Bahari")
                .setMerchantLocation("Solo")
                .setStatus(true);

        Merchant warteg2 = new Merchant()
                .setMerchantId(2)
                .setMerchantName("Warteg Pojok")
                .setMerchantLocation("Boyolali")
                .setStatus(false);

        merchantList.add(warteg1);
        merchantList.add(warteg2);
    }

    public static void initiateProduct(){
        Merchant warteg1 = new Merchant();
        Merchant warteg2 = new Merchant();

        Product nasiGoreng = new Product()
                .setProductId(1)
                .setProductName("Nasi Goreng")
                .setPrice(15000)
                .setMerchant(warteg1);

        Product mieGoreng = new Product()
                .setProductId(2)
                .setProductName("Mie Goreng")
                .setPrice(13000)
                .setMerchant(warteg1);

        Product nasiAyam = new Product()
                .setProductId(3)
                .setProductName("Nasi + Ayam")
                .setPrice(18000)
                .setMerchant(warteg1);

        Product esTehManis = new Product()
                .setProductId(4)
                .setProductName("Es Teh Manis")
                .setPrice(3000)
                .setMerchant(warteg1);

        Product esJeruk = new Product()
                .setProductId(5)
                .setProductName("Es Jeruk")
                .setPrice(5000)
                .setMerchant(warteg1);

        productMap.put(nasiGoreng.getProductId(), nasiGoreng);
        productMap.put(mieGoreng.getProductId(), mieGoreng);
        productMap.put(nasiAyam.getProductId(), nasiAyam);
        productMap.put(esTehManis.getProductId(), esTehManis);
        productMap.put(esJeruk.getProductId(), esJeruk);

        Product nasiGoreng2 = new Product()
                .setProductId(1)
                .setProductName("Nasi Goreng")
                .setPrice(15000)
                .setMerchant(warteg2);

        Product mieGoreng2 = new Product()
                .setProductId(2)
                .setProductName("Mie Goreng")
                .setPrice(13000)
                .setMerchant(warteg2);

        Product nasiAyam2 = new Product()
                .setProductId(3)
                .setProductName("Nasi + Ayam")
                .setPrice(18000)
                .setMerchant(warteg2);

        Product esTehManis2 = new Product()
                .setProductId(4)
                .setProductName("Es Teh Manis")
                .setPrice(3000)
                .setMerchant(warteg2);

        Product esJeruk2 = new Product()
                .setProductId(5)
                .setProductName("Es Jeruk")
                .setPrice(5000)
                .setMerchant(warteg2);

        productMap.put(nasiGoreng2.getProductId(), nasiGoreng2);
        productMap.put(mieGoreng2.getProductId(), mieGoreng2);
        productMap.put(nasiAyam2.getProductId(), nasiAyam2);
        productMap.put(esTehManis2.getProductId(), esTehManis2);
        productMap.put(esJeruk2.getProductId(), esJeruk2);
    }

}

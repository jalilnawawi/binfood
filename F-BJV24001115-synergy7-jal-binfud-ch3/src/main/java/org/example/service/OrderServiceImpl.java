package org.example.service;

import org.example.Data;
import org.example.controller.OrderController;
import org.example.controller.ProductController;
import org.example.model.Order;
import org.example.model.OrderDetail;
import org.example.model.Product;
import org.example.view.OrderView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class OrderServiceImpl implements OrderService {
    Map<String, OrderDetail> orderDetailMap = Data.orderDetailMap;
    Map<String, Order> orderMap = Data.orderMap;

    ProductController productController = new ProductController();
    OrderController orderController = new OrderController();
    OrderView orderView = new OrderView();
    @Override
    public Product getProduct(int selectedProductid) {
        return Data.productMap.get(selectedProductid);
    }

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public int selectProduct(int selectProduct) {
        Order order = new Order()
                .setOrderTime(LocalDateTime.now())
                .setDestinationAddress("Surakarta");
        orderMap.put(order.getOrderId(), order);

        if (selectProduct >= 1 && selectProduct <= 5){
            int inputQty = orderController.inputQty();
            if (inputQty == 0){
                throw new NullRequestException(
                        "\n============================\n"
                                + "Minimal 1 jumlah pesanan\n"
                                + "============================\n"
                );
            }
            Product productSelected = getProduct(selectProduct);
            OrderDetail orderDetail = new OrderDetail()
                    .setProduct(productSelected)
                    .setQuantity(inputQty)
                    .setOrder(order);
            orderDetailMap.put(generateId(), orderDetail);
        } else if (selectProduct > 5){
            orderView.displayOutsideExistingOption();
            Scanner scanner = new Scanner(System.in);
            String outsideOption = scanner.next();

            if (outsideOption.equalsIgnoreCase("y")){
                productController.mainMenu();
                orderController.selectProduct();
            } else if (outsideOption.equalsIgnoreCase("n")) {
                System.exit(1);
            }
        } else if (selectProduct == 0){
            System.exit(1);
        }
        return selectProduct;
    }

    @Override
    public int totalQty() {
        int totalQty = 0;
        for (String key : orderDetailMap.keySet()){
            totalQty += orderDetailMap.get(key).getQuantity();
        }
        return totalQty;
    }

    @Override
    public int totalPrice() {
        int totalPrice = 0;
        for (String key: orderDetailMap.keySet()){
            totalPrice += orderDetailMap.get(key).getQuantity()
                    *
                    orderDetailMap.get(key).getProduct().getPrice();
        }
        return totalPrice;
    }

    @Override
    public void confirmPay() {
        orderView.displayConfirmPayHeader();

        orderDetailMap.forEach((key, value) -> System.out.println(
                value.getProduct().getProductName() + " | "
                + value.getQuantity() + " | "
                + value.getProduct().getPrice()
        ));
        int totalQty = totalQty();
        int totalPrice = totalPrice();
        System.out.println("-----------------------------+");
        System.out.println("Total " + "\t" + totalQty + " | " + totalPrice);
    }

    @Override
    public void confirmPaySelection() {
    orderView.displayConfirmPaySelection();
        Scanner scanner = new Scanner(System.in);
        int selectedMenu = scanner.nextInt();
        Optional<Integer> selectedMenuOptional = Optional.of(selectedMenu);
        selectedMenuOptional.ifPresentOrElse(
                menu -> {
                    if (menu == 1){
                        printReceipt();
                    } else if (menu == 2) {
                        System.out.println();
                        productController.mainMenu();
                        orderController.selectProduct();
                        confirmPay();
                        confirmPaySelection();
                    } else if (menu == 3){
                        System.exit(1);
                    } else {
                        System.out.println("menu pilihanmu tidak valid");
                    }
                }, () -> System.exit(1)
        );
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt Printed");

        try {
            FileWriter writer = new FileWriter("receipt.txt");
            BufferedWriter bwr  = new BufferedWriter(writer);
            for (String key : orderMap.keySet()){
                bwr.write(
                        "OrderId = "
                                + orderMap.get(key).setOrderId(generateId()).getOrderId()
                                + "\n"
                                + "Order Time = "
                                + orderMap.get(key).getOrderTime()
                                + "\n"
                );
            }

            //gpt merapikan
            bwr.write("===============================\n");
            bwr.write("BinarFud\n");
            bwr.write("===============================\n\n");
            bwr.write("Terima kasih sudah memesan di BinarFud\n\n");
            bwr.write("Dibawah ini adalah pesanan anda:\n\n");

            for (String key : orderDetailMap.keySet()){
                OrderDetail orderDetail = orderDetailMap.get(key);
                Product product = orderDetail.getProduct();
                int quantity = orderDetail.getQuantity();
                double price = product.getPrice();
                String productName = product.getProductName();
                bwr.write(
                        productName + "\t" + "\t".repeat(2) + quantity + "\t" + price
                        + "\n"
                        );
            }
            int totalQty = totalQty();
            double totalPrice = totalPrice();

            //gpt merapikan
            bwr.write("--------------------------------" + "\n");
            bwr.write("Total " + "\t".repeat(4) + totalQty + "\t" + totalPrice + "\n");
            bwr.write("Pembayaran : BinarCash\n\n");
            bwr.write("===============================\n");
            bwr.write("Simpan struk ini sebagai bukti pembayaran\n");
            bwr.write("===============================\n");
            bwr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

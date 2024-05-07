package com.example.challenge4.controller;

import com.example.challenge4.model.*;
import com.example.challenge4.service.*;
import com.example.challenge4.view.OrderDetailView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Component
@Slf4j
public class OrderController {
    @Autowired
    UsersService usersService;

    @Autowired
    UserController userController;

    @Autowired
    MerchantController merchantController;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ProductService productService;

    OrderDetailView orderDetailView = new OrderDetailView();

    Users user;
    Merchant merchant;
    Product selectedProduct;
    Order order;

    List<Order> orderList = new ArrayList<>();
    Map<Long, OrderDetail> orderDetailMap = new LinkedHashMap<>();

    public void mainMenu(){
        createOrder();
        selectMerchant();
        selectProduct();
        confirmPay();
        confirmPaySelection();
    }

    public Long generateIdForMap(){
        Random random = new Random();
        Long randomId = random.nextLong();
        return randomId;
    }

    public void createOrder(){
        order = new Order();
        order.setOrderTime(LocalDate.now());
        user = usersService.getUserByUsername(userController.getUserByUsername());
        order.setUsers(user);
        orderService.create(order);
        orderList.add(order);
        System.out.println("Selamat berbelanja " + order.getUsers().getUsername());

    }

    public void selectMerchant(){
        merchant = merchantController.showMerchantByInputName();
    }

    public void selectProduct(){
        System.out.println("===========================");
        System.out.println("\t" + merchant.getName() + "\t");
        System.out.println("===========================");
        List<Product> productList = productService
                .showProductFromSelectedMerchant(merchant);
        productList.forEach(product -> System.out.println(
                product.getName() + " | " + product.getPrice()
        ));
        System.out.println("===========================");
        orderDetailView.displaySelectProduct();
        Scanner select = new Scanner(System.in);
        String inputProductName = select.nextLine();
        selectedProduct = productService.getProductByName(inputProductName);
        if (selectedProduct != null){
            int quantity = inputQty();
            if (quantity == 0){
                throw new NullRequestException(
                        "\n============================\n"
                                + "Minimal 1 jumlah pesanan\n"
                                + "============================\n"
                );
            }
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(selectedProduct);
            orderDetail.setQuantity(quantity);
            orderDetailService.create(orderDetail);
            orderDetailMap.put(generateIdForMap(), orderDetail);
        }

    }

    public int inputQty(){
        orderDetailView.displayInputQuantity();
        Scanner scanner = new Scanner(System.in);
        int inputQty = scanner.nextInt();
        return inputQty;
    }

    public void confirmPay(){
        orderDetailView.displayConfirmPayHeader();
        orderDetailMap.forEach((aLong, orderDetail) -> System.out.println(
                orderDetail.getProduct().getName() + " | "
                + orderDetail.getQuantity() + " | "
                + orderDetail.getProduct().getPrice()
        ));

        int totalQty = totalQty();
        int totalPrice = totalPrice();
        System.out.println("-----------------------------+");
        System.out.println("Total " + "\t" + totalQty + " | " + totalPrice);
    }

    public int totalQty(){
        int totalQty = 0;
        for (Long key : orderDetailMap.keySet()){
           totalQty += orderDetailMap.get(key).getQuantity();
        }
        return totalQty;
    }

    public int totalPrice(){
        int totalPrice = 0;
        for (Long key : orderDetailMap.keySet()){
            totalPrice += orderDetailMap.get(key).getQuantity()
                    *
                    orderDetailMap.get(key).getProduct().getPrice();
        }
        return totalPrice;
    }

    public void confirmPaySelection(){
        orderDetailView.displayConfirmPaySelection();
        Scanner scanner = new Scanner(System.in);
        int selectedMenu = scanner.nextInt();
        Optional<Integer> selectedMenuOptional = Optional.of(selectedMenu);
        selectedMenuOptional.ifPresentOrElse(
                menu -> {
                    if (menu == 1){
                        printReceipt();
                    } else if (menu == 2) {
                        System.out.println();
                        selectProduct();
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

    public void printReceipt() {
        System.out.println("Receipt Printed");

        try {
            FileWriter writer = new FileWriter("receipt.txt");
            BufferedWriter bwr  = new BufferedWriter(writer);
            for (Order order1 : orderList) {
                bwr.write(
                        "Order Id = " + order1.getId() + "\n"
                                + "Order Time = " + order1.getOrderTime() + "\n"
                );
            }

            bwr.write("===============================\n");
            bwr.write("BinarFud\n");
            bwr.write("===============================\n\n");
            bwr.write("Terima kasih sudah memesan di BinarFud\n\n");
            bwr.write("Dibawah ini adalah pesanan anda:\n\n");

            bwr.write("--------------------------------\n");
            for (Long key : orderDetailMap.keySet()){
                bwr.write(
                        orderDetailMap.get(key).getProduct().getName() +
                                "\t"
                        + orderDetailMap.get(key).getQuantity() + "\t"
                        + orderDetailMap.get(key).getProduct().getPrice()
                        + "\n"
                );
            }

            int totalQty = totalQty();
            double totalPrice = totalPrice();

            //gpt merapikan
            bwr.write("--------------------------------" + "\n");
            bwr.write("Total " + "\t".repeat(2) + totalQty + "\t" + totalPrice + "\n");
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

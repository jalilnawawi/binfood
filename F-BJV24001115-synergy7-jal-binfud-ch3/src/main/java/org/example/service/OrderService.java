package org.example.service;

import org.example.model.Product;

public interface OrderService {
    Product getProduct (int selectedProductid);
    String generateId();
    int selectProduct(int selectProduct);
//    void inputQty(int inputQty);
//    OrderDetail getOrderDetail ();
    int totalQty();
    int totalPrice();
    void confirmPay();
    void confirmPaySelection();
    void printReceipt();
}

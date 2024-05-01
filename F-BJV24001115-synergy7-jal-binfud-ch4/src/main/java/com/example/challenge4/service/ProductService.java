package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> showAllProduct();
    List<Product> showProductFromSelectedMerchant(Merchant merchant);
    Product getProductByName(String name);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}

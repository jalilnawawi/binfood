package org.example.controller;

import org.example.Data;
import org.example.model.Merchant;
import org.example.model.Product;
import org.example.service.*;
import org.example.view.OrderView;
import org.example.view.ProductView;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ProductController {
    public void mainMenu(){
        Data.initiateProduct();

        Supplier<TreeMap<Integer, Product>> productSupplier = () -> Data.productMap;
        ProductView productView = new ProductView();
        productView.displayProduct(productSupplier.get());
    }
}

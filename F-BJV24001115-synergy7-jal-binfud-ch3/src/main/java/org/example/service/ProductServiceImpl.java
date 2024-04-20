package org.example.service;

import org.example.Data;
import org.example.model.Product;
import org.example.view.ProductView;

import java.util.TreeMap;

public class ProductServiceImpl implements ProductService{
    @Override
    public TreeMap<Integer, Product> getProduct() {
        return Data.productMap;
    }
}

package org.example.service;

import org.example.model.Product;

import java.util.Optional;
import java.util.TreeMap;

public interface ProductService {
    TreeMap<Integer, Product> getProduct();
}

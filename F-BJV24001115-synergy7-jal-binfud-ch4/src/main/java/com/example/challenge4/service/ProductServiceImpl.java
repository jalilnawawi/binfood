package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Product;
import com.example.challenge4.repository.MerchantRepository;
import com.example.challenge4.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Product create(Product product) {
        product = productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> showAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByName(String name) {
        Optional<Product> productOptional = productRepository.getProductByName(name);
        return productOptional.get();
    }

    @Override
    public void updateProduct(Product product) {
        product = productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        product = productRepository.save(product);
    }

    @Override
    public List<Product> showProductFromSelectedMerchant(Merchant merchant) {
        List<Product> productList = productRepository.findProductByMerchant(merchant);
        return productList;
    }
}

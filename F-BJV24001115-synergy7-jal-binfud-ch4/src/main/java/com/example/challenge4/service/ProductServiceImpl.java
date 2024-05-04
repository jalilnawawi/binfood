package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Product;
import com.example.challenge4.repository.MerchantRepository;
import com.example.challenge4.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product showProductFromSelectedMerchant(Merchant merchant) {
        Product product = productRepository.getProductByMerchant(merchant);
        return product;
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
    public Product getProductByNameAndMerchant(String name, String merchantName) {

        return null;
    }
}

package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.OrderDetail;
import com.example.challenge4.model.Product;
import com.example.challenge4.repository.MerchantRepository;
import com.example.challenge4.repository.OrderDetailRepository;
import com.example.challenge4.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    ProductService productService;



    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        orderDetail = orderDetailRepository.save(orderDetail);
        return orderDetail;
    }

    @Override
    public Product selectProduct(int selectProduct, Merchant merchant) {
        List<Product> productList = productService.showAllProduct()
                .stream().filter(product -> product.getMerchant().equals(merchant))
                .toList();

        return productList.get(selectProduct);
    }

    @Override
    public int quantity() {
        return 0;
    }
}

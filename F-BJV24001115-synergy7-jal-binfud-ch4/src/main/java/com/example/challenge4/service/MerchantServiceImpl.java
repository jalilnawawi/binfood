package com.example.challenge4.service;

import com.example.challenge4.controller.MerchantController;
import com.example.challenge4.model.Merchant;
import com.example.challenge4.repository.MerchantRepository;
import com.example.challenge4.view.MerchantView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService{
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        merchantRepository.save(merchant);
        return merchant;
    }
}

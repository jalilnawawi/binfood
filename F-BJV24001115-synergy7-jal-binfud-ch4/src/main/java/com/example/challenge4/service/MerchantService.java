package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;

import java.util.List;


public interface MerchantService {
    Merchant create(Merchant merchant);
    List<Merchant> showAllMerchant();
    List<Merchant> showExistingMerchant();
    List<Merchant> showOpenMerchant();
    Merchant getMerchantByName(String name);
    void updateMerchant(Merchant merchant);
    void deleteMerchant(Merchant merchant);
}

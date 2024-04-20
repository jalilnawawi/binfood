package org.example.service;

import org.example.model.Merchant;

import java.util.List;

public interface MerchantService {
    List<Merchant> getMerchant();
    int selectMerchantById(int merchantId);
}

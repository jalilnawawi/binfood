package com.example.challenge4.service;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.repository.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService{
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        merchant = merchantRepository.save(merchant);
        return merchant;
    }

    @Override
    public List<Merchant> showAllMerchant() {
        return merchantRepository.findAll();
    }

    @Override
    public List<Merchant> showExistingMerchant() {
        return merchantRepository.findExistingMerchant();
    }

    @Override
    public List<Merchant> showOpenMerchant() {
        return merchantRepository.findOpenMerchant();
    }

    @Override
    public Merchant getMerchantByName(String name) {
        Optional<Merchant> merchantOptional = merchantRepository
                .findByName(name);
        return merchantOptional.get();
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        merchant = merchantRepository.save(merchant);
    }

    @Override
    public void deleteMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }
}

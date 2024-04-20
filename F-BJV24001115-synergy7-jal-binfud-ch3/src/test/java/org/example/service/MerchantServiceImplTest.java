package org.example.service;

import org.example.Data;
import org.example.model.Merchant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MerchantServiceImplTest {
    MerchantService merchantService = new MerchantServiceImpl();
    @Test
    void getMerchant() {
        List<Merchant> result = merchantService.getMerchant();
        assertEquals(Data.merchantList, result);
    }

    @Test
    void selectMerchantById() {
        int merchantId = 1;

        int result = merchantService.selectMerchantById(merchantId);

        assertEquals(1,result);
    }
}
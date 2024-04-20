package org.example.service;

import org.example.Data;
import org.example.model.Merchant;
import org.example.view.MerchantView;

import java.util.List;
import java.util.Scanner;

public class MerchantServiceImpl implements MerchantService{
    MerchantView merchantView = new MerchantView();
    @Override
    public List<Merchant> getMerchant() {
        merchantView.displayMerchantView();
        return Data.merchantList;
    }

    @Override
    public int selectMerchantById(int merchantId) {
        if (merchantId == 0 || merchantId > 2){
            throw new NullRequestException(
                    "\n============================\n"
                            + "Merchant tidak ditemukan!\n"
                            + "============================\n"
            );
        }

        return merchantId;
    }
}

package org.example.view;

import org.example.Data;
import org.example.model.Merchant;

import java.util.List;
import java.util.Optional;

public class MerchantView {
    List<Merchant> merchantList = Data.merchantList;
    public void displayMerchantView(){
        System.out.println("Berikut daftar Merchant");
        merchantList.forEach(merchant -> System.out.println(
                merchant.getMerchantId() + ". " +
                merchant.getMerchantName()
        ));
    }

    public void displayInputMerchantNameView(){
        System.out.print("Mau beli makan dimana : ");
    }
}

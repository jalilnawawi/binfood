package org.example.controller;

import org.example.Data;
import org.example.service.MerchantService;
import org.example.service.MerchantServiceImpl;
import org.example.view.MerchantView;

import java.util.Scanner;

public class MerchantController {
    public void merchantController(){
        Data.initiateMerchant();
        MerchantService merchantService = new MerchantServiceImpl();
        merchantService.getMerchant();

        MerchantView merchantView = new MerchantView();
        merchantView.displayInputMerchantNameView();
        Scanner input = new Scanner(System.in);
        int inputMerchantName = input.nextInt();
        merchantService.selectMerchantById(inputMerchantName);
    }
}

package com.example.challenge4.controller;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.service.MerchantService;
import com.example.challenge4.service.MerchantServiceImpl;
import com.example.challenge4.view.MerchantView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class MerchantController {
    @Autowired
    MerchantView merchantView;

    public void mainMenu(){
        System.out.println("Silahkan isi form");

        Merchant merchant = new Merchant();
        Scanner scanner = new Scanner(System.in);
        merchantView.displayInputNama();
        String nama = scanner.next();
        scanner.nextLine();

        merchantView.displayInputLokasi();
        String location = scanner.next();
        scanner.nextLine();

        merchantView.displayInputStatus();
        Boolean open = scanner.nextBoolean();
        scanner.nextLine();

        merchant.setName(nama);
        merchant.setLocation(location);
        merchant.setOpen(open);

        MerchantService merchantService = new MerchantServiceImpl();
        merchantService.create(merchant);
    }
}

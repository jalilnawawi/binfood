package com.example.challenge4.controller;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.service.MerchantService;
import com.example.challenge4.view.MerchantView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
public class MerchantController {
    @Autowired
    MerchantView merchantView;

    @Autowired
    MerchantService merchantService;

    public void mainMenu(){
//        createMerchant();
//        showAllMerchant();
//        showExistingMerchant();
        showMerchantWithStatusOpen();
        showMerchantByInputName();
//        updateMerchant();
//        deleteMerchant();
    }

    public void createMerchant(){
        System.out.println("Silahkan isi form");

        Merchant merchant = new Merchant();
        Scanner scanner = new Scanner(System.in);
        merchantView.displayInputNama();
        String nama = scanner.nextLine();

        merchantView.displayInputLokasi();
        String location = scanner.nextLine();

        merchantView.displayInputStatus();
        Boolean open = scanner.nextBoolean();

        merchant.setName(nama);
        merchant.setLocation(location);
        merchant.setOpen(open);

        merchant = merchantService.create(merchant);
        System.out.println(merchant.getId());
    }

    public void showAllMerchant(){
        List<Merchant> merchants = merchantService.showAllMerchant();
        merchants.forEach(merchant -> System.out.println(
                merchant.getName() + " | " + merchant.getLocation()
        ));
    }

    public void showExistingMerchant(){
        List<Merchant> merchants = merchantService.showExistingMerchant();
        merchants.forEach(merchant -> System.out.println(
                merchant.getName() + " | " + merchant.getLocation()
        ));
    }

    public void showMerchantWithStatusOpen(){
        List<Merchant> merchants = merchantService.showOpenMerchant();
        System.out.println();
        System.out.println("===========================");
        merchants.forEach(merchant -> System.out.println(
                merchant.getName()
        ));
        System.out.println("===========================");
        System.out.println();
    }

    public Merchant showMerchantByInputName(){
        System.out.print("Silahkan pilih resto = ");
        Scanner scanner = new Scanner(System.in);
        String merchantName = scanner.nextLine();

        Merchant selectMerchantByName = merchantService.getMerchantByName(merchantName);
//        System.out.println("berikut data dari merchant " + selectMerchantByName.getName());
//        System.out.println(selectMerchantByName.getName() +
//                " | " + selectMerchantByName.getLocation() +
//                " | " + selectMerchantByName.isOpen()
//                );
        return selectMerchantByName;
    }

    public void updateMerchant(){
        System.out.println("Input nama merchant anda = ");
        Scanner scanner = new Scanner(System.in);
        String merchantName = scanner.nextLine();

        Merchant selectMerchant = merchantService.getMerchantByName(merchantName);

        System.out.println("Input value terbaru");
        Scanner update = new Scanner(System.in);
        merchantView.displayInputNama();
        String name = update.nextLine();

        merchantView.displayInputLokasi();
        String location = update.nextLine();

        merchantView.displayInputStatus();
        Boolean open = update.nextBoolean();

        selectMerchant.setName(name);
        selectMerchant.setLocation(location);
        selectMerchant.setOpen(open);

        merchantService.updateMerchant(selectMerchant);
        System.out.println("Merchant dengan nama = " +
                selectMerchant.getName() + " berhasil diupdate"
        );
    }

    public void deleteMerchant(){
        System.out.println("Input nama merchant yang akan dihapus = ");
        Scanner scanner = new Scanner(System.in);
        String merchantName = scanner.nextLine();

        Merchant selectMerchant = merchantService.getMerchantByName(merchantName);

        selectMerchant.setDeleted(true);
        merchantService.deleteMerchant(selectMerchant);
        System.out.println("Merchant dengan nama = " +
                selectMerchant.getName() + " berhasil dihapus"
        );
    }

}

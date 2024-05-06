package com.example.challenge4.controller;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.service.MerchantService;
import com.example.challenge4.view.MerchantView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Component
@Slf4j
public class MerchantController {
    @Autowired
    MerchantView merchantView;

    @Autowired
    MerchantService merchantService;

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        merchantView.merchantServiceDisplay();
        System.out.print("Pilih opsi => ");
        int selectMenu = scanner.nextInt();
        if (selectMenu == 1){
            createMerchant();
        } else if (selectMenu == 2) {
            showAllMerchant();
        } else if (selectMenu == 3) {
            updateMerchant();
        } else if (selectMenu == 4) {
            deleteMerchant();
        }
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
        showMerchantWithStatusOpen();
        System.out.print("Silahkan pilih resto = ");
        Scanner scanner = new Scanner(System.in);
        String merchantName = scanner.nextLine();

        return merchantService.getMerchantByName(merchantName);
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

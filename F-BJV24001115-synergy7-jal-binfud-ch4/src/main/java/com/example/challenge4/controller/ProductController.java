package com.example.challenge4.controller;

import com.example.challenge4.model.Merchant;
import com.example.challenge4.model.Product;
import com.example.challenge4.service.MerchantService;
import com.example.challenge4.service.ProductService;
import com.example.challenge4.view.ProductView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    MerchantService merchantService;

    @Autowired
    MerchantController merchantController;
    ProductView productView = new ProductView();

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        productView.productServiceDisplay();
        System.out.print("Pilih opsi => ");
        int selectMenu = scanner.nextInt();
        if (selectMenu == 1){
            createProduct();
        } else if (selectMenu == 2) {
            showAllProduct();
        } else if (selectMenu == 3){
            showProductByMerchant();
        } else if (selectMenu == 4) {
            updateProduct();
        } else if (selectMenu == 5) {
            deleteProduct();
        }
    }


    public void createProduct(){
        merchantController.showAllMerchant();
        System.out.print("Input nama merchant anda = ");
        Scanner scanner = new Scanner(System.in);
        String merchantName = scanner.nextLine();

        Merchant selectMerchant = merchantService.getMerchantByName(merchantName);

        System.out.println("Silahkan isi form");

        Product product = new Product();
        Scanner productInput = new Scanner(System.in);
        productView.displayInputNama();
        String nama = productInput.nextLine();

        productView.displayInputHarga();
        int price = productInput.nextInt();

        product.setName(nama);
        product.setPrice(price);
        product.setMerchant(selectMerchant);

        productService.create(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        System.out.println("Produk berhasil ditambahkan ke " + product.getMerchant().getName());
    }

    public void showAllProduct(){
        List<Product> productList = productService.showAllProduct();
        productView.displayHeader();
        productList.forEach(product -> System.out.println(
                product.getMerchant().getName() + " | " + "\t"
                + product.getName() + " | " + "\t"
                + product.getPrice()
        ));
    }

    public void updateProduct(){
        System.out.println("Input nama produk yang akan diperbarui");
        System.out.print("=> ");

        Scanner inputProductName = new Scanner(System.in);
        String productName = inputProductName.nextLine();

        Product selectProduct = productService.getProductByName(productName);

        System.out.println("Silahkan input form perbaruan produk");
        Scanner updateProduct = new Scanner(System.in);

        productView.displayInputNama();
        String updateName = updateProduct.nextLine();

        productView.displayInputHarga();
        int updatePrice = updateProduct.nextInt();

        selectProduct.setName(updateName);
        selectProduct.setPrice(updatePrice);

        productService.updateProduct(selectProduct);
        System.out.println("berhasil memperbarui menu " + selectProduct.getName());
    }

    public void deleteProduct(){
        System.out.println("Input nama produk yang akan dihapus");
        System.out.println("=> ");

        Scanner inputProductName = new Scanner(System.in);
        String productName = inputProductName.nextLine();

        Product selectProduct = productService.getProductByName(productName);

        selectProduct.setDeleted(true);
        productService.deleteProduct(selectProduct);
        System.out.println("Menu " + selectProduct.getName() +
                " berhasil dihapus"
                );
    }

    public void getProductByName(){
        System.out.println("Input Nama Produk");
        System.out.println("=> ");
        Scanner scanner = new Scanner(System.in);
        String productName = scanner.nextLine();

        Product selectProduct = productService.getProductByName(productName);
        System.out.println(
                selectProduct.getName() + " | " + "\t"
                + selectProduct.getPrice() + " | " + "\t"
                + selectProduct.getMerchant().getName()
        );
    }

    public void showProductByMerchant(){
        Merchant merchant = merchantController.showMerchantByInputName();
        List<Product> productList = productService.showProductFromSelectedMerchant(merchant);
        System.out.println("===========================");
        System.out.println("\t" + merchant.getName() + "\t");
        System.out.println("===========================");
        productList.forEach(product -> System.out.println(
                product.getName() + " | " + product.getPrice()
        ));
        System.out.println("===========================");
    }

}

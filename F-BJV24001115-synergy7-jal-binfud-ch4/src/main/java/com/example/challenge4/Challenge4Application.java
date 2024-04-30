package com.example.challenge4;

import com.example.challenge4.controller.MerchantController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge4Application {

	public static void main(String[] args) {
		MerchantController merchantController =
		SpringApplication.run(Challenge4Application.class, args).getBean(MerchantController.class);
		merchantController.mainMenu();
	}

}

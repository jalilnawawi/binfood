package com.example.challenge4;

import com.example.challenge4.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Challenge4Application {

	public static void main(String[] args) {
		MainController mainController =
		SpringApplication.run(Challenge4Application.class, args).getBean(MainController.class);
		mainController.mainController();

	}

}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.BenzenoidDAO;

@SpringBootApplication(scanBasePackages = { "com.example.dao", "com.example.demo", "com.example.model",
		"com.example.web", "com.example.service" })
public class BenzenoidManagementApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("mysql")
	BenzenoidDAO benzenoidDAO;

	public static void main(String[] args) {
		SpringApplication.run(BenzenoidManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}

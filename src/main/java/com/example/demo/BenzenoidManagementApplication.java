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

//		benzenoidDAO.save(new Benzenoid(3L, "test", 5, 10, 10, 0.0));
//		benzenoidDAO.save(new Benzenoid(2L, "test2", 5, 10, 10, 0.0));
//
//		Benzenoid benzenoidDB = benzenoidDAO.findById(2L).get();
//
//		System.out.println(benzenoidDB.getName());
//
//		benzenoidDB.setName("updated name");
//
//		benzenoidDAO.update(benzenoidDB);
//
//		Benzenoid benzenoidDB2 = benzenoidDAO.findById(2L).get();
//
//		System.out.println(benzenoidDB2.getName());

	}

}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.FileContentRepo;

@SpringBootApplication
public class TestFileUploadConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFileUploadConsumerApplication.class, args);
	}

	
	
}

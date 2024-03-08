package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nu.pattern.OpenCV;

@SpringBootApplication
public class OcrCustomApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcrCustomApiApplication.class, args);
		OpenCV.loadShared();

	}

}

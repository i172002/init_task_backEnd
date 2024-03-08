package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Response.Response;
import com.example.demo.controller.Ocr_Custom_Controller;

@SpringBootTest
class OcrCustomApiApplicationTests {
	
//	@Autowired
//	Ocr_Custom_Controller ocr_cust_controller;
//
//   @Test
//   void testWithDifferentPreprocessing() throws Exception {
//	   File image = new File("C:\\Users\\intern-infant\\Desktop\\original_images\\aadhar-front.jpg");
//	   FileInputStream input_image = new FileInputStream(image);
//	   MultipartFile multipartImage = new MockMultipartFile("input_image",
//	            image.getName(), "image/jpg", IOUtils.toByteArray(input_image));
//	   ResponseEntity<Response> responseEntity = ocr_cust_controller.getImageToText(multipartImage,true,true,false);
//	   assertNotNull(responseEntity.getBody());
//   }
	
}

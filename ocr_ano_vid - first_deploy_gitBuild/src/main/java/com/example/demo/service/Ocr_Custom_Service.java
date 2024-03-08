package com.example.demo.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ImgProcessing.AdaptiveThreshold;
import com.example.demo.ImgProcessing.Grayscale;
import com.example.demo.ImgProcessing.Threshold_Inc;
import com.example.demo.OCR.EOCR;
import com.example.demo.OCR.TessOCR;
import com.example.demo.Pojo.Aadhaar;
import com.example.demo.Pojo.AadharResp;
import com.example.demo.Pojo.Details_Front_Bottom;
import com.example.demo.Pojo.Father;
import com.example.demo.Pojo.Gender;
import com.example.demo.Pojo.ImageUrl;
import com.example.demo.Pojo.Mother;
import com.example.demo.Pojo.Name;
import com.example.demo.Pojo.Qr;
import com.example.demo.Pojo.ResponsePOJO;
import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.Yob;
import com.example.demo.Pojo.ano_vid_pojo;
import com.example.demo.Response.Response;
import com.lowagie.text.Image;

import MultipartFileToFile.MultipartFileToFile;

@Service //OCR Custom API's service
public class Ocr_Custom_Service {
	
//	@Autowired
//    AadharResp aadharResp;
//	
//	@Autowired
//	ResponsePOJO responsePOJO;

	public Response getImageToText(MultipartFile image) throws Exception{
		//user input image for final redaction
		try {
		File init_image = MultipartFileToFile.convertMultipartFileToFile(image);
		
		// selected pre-processed image //initally it is the input image 
		File processed_image = init_image;
		
//		if(adaptiveThreshold)
//		{
//			processed_image = AdaptiveThreshold.adaptiveThreshold(processed_image);
//		}
		
//		if(grayscale) {
		//if the grayscale is checked the init_image will be passed and the result is stored in processed_image
			processed_image = Grayscale.convertToGrayscale(processed_image);	
//		}
//		if(threshold)
//		{
//			processed_image = Threshold_Inc.threshold_inc(processed_image);	
//
//		}
		
				
	    
		//Map<String, String> ocr_result = TessOCR.doTessOCR(processed_image,"PreProcessed Image");
		
		Map<String, String> ocr_result_easy_ocr = EOCR.doEasyOCR(new FileInputStream(processed_image),"PreProcessed Image");
		
       		
	    
//		
//        BufferedImage bf=ImageIO.read(processed_image);
//        //WRITING THE PRE PROCESSED IMAGE TO THE SYSTEM
//        String img_name = processed_image.getName();
//        String extension  = img_name.substring(img_name.lastIndexOf(".") + 1);
//        File improved_image = new File ("C:\\Users\\intern-infant\\Desktop\\custom_preprocessed"+File.separator+img_name);
//        ImageIO.write(bf, extension, improved_image);
		try {
            if(Files.deleteIfExists(Paths.get(processed_image.getAbsolutePath())))
            {
            	System.out.println("In Service Grayscale Deleted Successfully");
            }
        }
        catch (Exception e) {
          e.printStackTrace(); 
        }
		init_image.delete();
		
		
		return new Response(200,"Image Reading Completed",new ano_vid_pojo(ocr_result_easy_ocr.get("adharNo"), ocr_result_easy_ocr.get("vid")));

	  }catch(Exception e) {
		  e.printStackTrace();
		  return new Response(200,"Image Reading Error",null);

	  }

   }
}

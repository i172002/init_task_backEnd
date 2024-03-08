package com.example.demo.ImgProcessing;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.web.multipart.MultipartFile;

import MultipartFileToFile.MultipartFileToFile;

public class AdaptiveThreshold {
	   public static File adaptiveThreshold(File image) throws Exception {
		   String output_directory = "C:\\Users\\intern-infant\\Desktop\\customAdaptiveThreshold\\";
           String image_name = image.getName();
           String output_path = output_directory + "Adaptive_Thresholded_" + image_name;
	      
	      // Reading the image
	      Mat src = Imgcodecs.imread(image.getName(),0);

	      // Creating an empty matrix to store the result
	      Mat dst = new Mat();

	      Imgproc.adaptiveThreshold(src, dst, 125, Imgproc.ADAPTIVE_THRESH_MEAN_C,
	         Imgproc.THRESH_BINARY, 11, 12);

	      // Writing the image
	      Imgcodecs.imwrite(output_path, dst);

	      System.out.println("Adaptive Threshold Completed");
	      
		    return new File(output_path);
	   } 
	}
package com.example.demo.ImgProcessing;


import java.io.File;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.web.multipart.MultipartFile;

import MultipartFileToFile.MultipartFileToFile;

public class Threshold_Inc{

	public static File threshold_inc(File image) {
        try {
            String output_directory = "C:\\Users\\intern-infant\\Desktop\\customThreshold\\";
            String image_name = image.getName();
            String output_path = output_directory + "Thresholded_" + image_name;
            
            Mat source = Imgcodecs.imread(image.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
            Mat destination = new Mat(source.rows(), source.cols(), source.type());
            destination = source.clone();
            Imgproc.threshold(source, destination, 127, 255, Imgproc.THRESH_TOZERO);
            Imgcodecs.imwrite(output_path, destination);
            
            System.out.println("Threshold completed");
            File output_image = new File(output_path);
            
            return output_image;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
	
}

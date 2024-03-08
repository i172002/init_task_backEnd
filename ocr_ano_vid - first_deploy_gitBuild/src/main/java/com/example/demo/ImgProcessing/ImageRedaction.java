package com.example.demo.ImgProcessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import MultipartFileToFile.MultipartFileToFile;

public class ImageRedaction {
    public static File imageRedaction(Rectangle coordinates1, Rectangle coordinates2,File image,MultipartFile init_image) {
        // Load the original image
        BufferedImage originalImage = null;

        try {
        	//input_image sent via API call(plain_image)
        	File plain_image = MultipartFileToFile.convertMultipartFileToFile(init_image);
            originalImage = ImageIO.read(new File(plain_image.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
           
        }

        // Mask the first rectangle
        maskRectangle(originalImage, coordinates1);

        // Mask the second rectangle
        maskRectangle(originalImage, coordinates2);

        // Save the modified image
        try {
        	String image_name = image.getName();
            File redacted_output = new File("C:\\Users\\intern-infant\\Desktop\\"+
                    image_name+"-masked"+"."+image_name.substring(image_name.lastIndexOf(".")+1));
            ImageIO.write(originalImage, "jpg", redacted_output);
            return redacted_output;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //apply the black rectangle in the given coordinates 
    private static void maskRectangle(BufferedImage image, Rectangle rect) {
        int redactX = rect.x;
        int redactY = rect.y;
        int redactWidth = (int) rect.getWidth();
        int redactHeight = (int) rect.getHeight();

        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(redactX, redactY, redactWidth, redactHeight);
        g.dispose();
    }
}

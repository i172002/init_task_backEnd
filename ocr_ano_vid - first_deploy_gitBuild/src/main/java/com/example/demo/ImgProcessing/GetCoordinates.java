package com.example.demo.ImgProcessing;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.Image;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

public class GetCoordinates {
	public static File getCoordinates(String no1,String no2,File image,MultipartFile init_image)  {
	    System.out.println("getBoundingBoxOfText for a given string :"+no1+" "+no2);
		
	    File imageFile = new File(image.getAbsolutePath());
	    BufferedImage bi=null;
	    String textToFind1 = no1,textToFind2 = no2;
	    
	    List<Rectangle> result = new ArrayList<>();
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ITesseract ts = new Tesseract();
        ts.setDatapath("D:\\softwares\\Tess4J\\tessdata");
        ts.setPageSegMode(1);
        ts.setLanguage("eng");
	   
	   

	    String recognizedText="";
		try {
			recognizedText = ts.doOCR(image); //extracting text from image
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    System.out.println(("Recognized text: \n" + recognizedText));
	    
        
        //to read the words from the input image
		
		
        List<Word> words = ts.getWords(bi, ITessAPI.TessPageIteratorLevel.RIL_WORD);
       
        
        
        
	   for (Word word : words) {
		   if (word.getText().equals(textToFind1)) {
           
		            Rectangle rect = word.getBoundingBox();
		            result.add(rect);
		            System.out.println("Bounding box of no1 "+ word.getText()+" "+ rect.x+" "+rect.y+" " + rect.width+" " +rect.height);
	           
       					}
		   if (word.getText().equals(textToFind2)) {
           
		           Rectangle rect = word.getBoundingBox();
		           result.add(rect);
		           System.out.println("Bounding box of no2 "+ word.getText()+" "+ rect.x+" "+rect.y+" " + rect.width+" " +rect.height);
		           //return;
               			}
		   
//		   System.out.println("This is Confidence -> "+word.getConfidence());
//		   System.out.println();
	    }//end of for loop
	    if(result.size()<2) //if the text is not found result array will be empty or less than 2
	    {
	        System.out.println("Text '" + textToFind1 + "' not found in the image.");
		    System.out.println("Text '" + textToFind2 + "' not found in the image.");
		    return null;
	    }
	    else
	    {
	    	//redacting the image function call with the coordinates
	        File redacted_image =ImageRedaction.imageRedaction(result.get(0),result.get(1),image,init_image);	
	        return redacted_image;
	    }
	    
	  
	    
	}

}

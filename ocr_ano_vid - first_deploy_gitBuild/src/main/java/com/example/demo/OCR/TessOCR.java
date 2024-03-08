package com.example.demo.OCR;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

public class TessOCR {

    static int name_conf = 0,dob_conf = 0,gender_conf = 0,
			   mobileNumber_conf=0,adharNo_conf=0,
			   vid_conf=0,father_conf=0;
	public static Map<String, String> doTessOCR(File image,String imageType) {
//		
//		//FirstName and LastName Regex
//	     String nameRegex  = "([A-Z][a-z]*\\s*)([A-Z][a-z]*\\s*)*(.*)";		
//	    //Regex to match string having format "dob: DD/MM/YYYY"
//	    Pattern dob_pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
//	     String genderRegex = ".*(female|male).*";
	     String aadharRegex = "^.*\\d{4}\\s+\\d{4}\\s+\\d{4}(.*)$";
//	     String mobileRegex = "d{10}";
//	     String fatherRegex = "c/o: (.*)";
	     Pattern vid_pattern = Pattern.compile("\\b\\d{4}(.*)\\d{4}(.*)\\d{4}(.*)\\d{4}\\b");

		String name = null,dob = null,gender = null,
				   mobileNumber=null,adharNo=null,
				   vid=null,father=null,adharno1=null,
				   adharno2=null;
		
		File imageFile = new File(image.getAbsolutePath());
	    BufferedImage bi=null;
		
	    try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Inside Tesseract OCR");
		
		ITesseract ts = new Tesseract();
		ts.setDatapath("D:\\softwares\\Tess4J\\tessdata");
        ts.setLanguage("eng");
        ts.setPageSegMode(1);
        
        List<Word> extracted_word = null;
        
		try {
//			text_from_image = ts.doOCR(image);
			extracted_word = ts.getWords(bi, ITessAPI.TessPageIteratorLevel.RIL_TEXTLINE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(imageType+" Extracted Text");
		for(Word word:extracted_word)
			System.out.println(word.getText()+" "+word.getConfidence());
        		

		for(Word word:extracted_word)
        	
        {
			String originalString  =  word.getText().replace("\n","");
			
			
        	String temp = originalString.toLowerCase();
//			Matcher dob_matcher = dob_pattern.matcher(temp);
			Matcher vid_matcher = vid_pattern.matcher(temp);

            
        	//dob value
//			if(dob == null &&dob_matcher.find()) 
//        	{
//        		System.out.println("DOB CONFIDENCE: "+word.getConfidence());
//
//        		System.out.println("Inside DOB: "+temp);
//        		dob = dob_matcher.group();
//        		//dob = i.split(": ")[1];
//        		
//        	}
        	
        	//name value
//        	if(originalString.matches(nameRegex) && name == null && father == null) 
//        	{
//        		System.out.println("NAME CONFIDENCE: "+word.getConfidence());
//
//        		name  = temp.replaceAll(nameRegex, "$1");
//        		//name = i;
//        		System.out.println("Name in if: "+name); 
//        	}
        	
        	//gender value
//        	if(temp.matches(genderRegex)) {
//        		System.out.println("GENDER CONFIDENCE: "+word.getConfidence());
//
//        		int startIndex;
//        		if(temp.indexOf("female")!=-1)
//        			startIndex = temp.indexOf("female");
//        		else 
//        			startIndex = temp.indexOf("male");
//        		gender  = temp.substring(startIndex,temp.lastIndexOf('e')+1);
//        	}
        	
        	//mobile NO finding
//        	if(temp.contains("mobile no: ") || temp.matches(mobileRegex)) 
//        	{
//        		System.out.println("MOBILE CONFIDENCE: "+word.getConfidence());
//
//        		mobileNumber = originalString.split(": ")[1];
//        		
//        	}
        	
        	//aadharNo finding
        	        	
        	//vid value
        	if(vid_matcher.find()) 
        	{
        		System.out.println("Inside VID: "+temp);
        		vid = vid_matcher.group();
//        		vid = i.split(" : ")[1];
        		
        	}
        	
//        	//father value
//        	if(temp.matches(fatherRegex)) {
//        		System.out.println("FATHER CONFIDENCE: "+word.getConfidence());
//
//        		System.out.println("Extract string Father: "+temp);
//        		father  =  originalString.split(": ")[1].split(",")[0];
//        		//father = temp.replaceAll(fatherRegex, "$1");
//        		System.out.println("Father name in if "+father);
//        	}
        	//System.out.println(temp);
        	if(temp.matches(aadharRegex) && adharNo==null ) 
        	{
        		System.out.println("AADHAR NO CONFIDENCE: "+word.getConfidence());

        		StringBuilder aadharString = new StringBuilder();
        		int numberCount = 0;
        		for (char c : temp.toCharArray()) {
        		    if (Character.isDigit(c)) {
        		        aadharString.append(c);
        		        numberCount++;
        		        
        		    }
        		    if(numberCount == 12)
        		    {
        		    	break;
        		    }
        		}
        		adharNo =  aadharString.toString();
        		System.out.println(adharNo);
        		adharno1 = adharNo.substring(0,4);
        		adharno2 = adharNo.substring(4,8);
        		adharNo = adharNo.replaceAll(" ", "");
        		adharNo = adharNo.replaceFirst("\\d{8}", "********");
        	}
        }
//           System.out.println("Name: "+name+"\n"+
//                           "DOB: "+dob+"\n"+"Gender: "+gender+"\n"+
//        		           "Mobile No: "+mobileNumber+"\n"+"Aadhaar: "+adharNo+"\n"+
//                           "VID: "+vid+"\n"+"Father "+father);
		   System.out.println("Aadhaar: "+adharNo+"\n"+ "VID: "+vid+"\n");
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append("Aadhaar: ").append(String.join(", ", adharNo)).append("\n")
                        .append("VID: ").append(String.join(", ", vid)).append("\n");
//                        .append("Name: ").append(String.join(", ", name)).append("\n")
//                        .append("DOB: ").append(String.join(", ", dob)).append("\n")
//                        .append("Gender: ").append(String.join(", ", gender)).append("\n")
//                        .append("Mobile No: ").append(String.join(", ", mobileNumber)).append("\n")
//                        .append("Father: ").append(String.join(", ", father));
           String result = stringBuilder.toString();
           File write_into = new File ("C:\\Users\\intern-infant\\Desktop\\Result-Tess-OCR\\Result-aadhar-vid-EasyOCR.txt");
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(write_into, true))) {
	       	    writer.write(imageType+" Extracted Text - TessOCR"+"\n\n"+"File Name: "+image.getName()+"\n\n");
	       	    writer.write(result);
	       	    writer.newLine();
	       	    writer.newLine();

	       	    System.out.println("Data has been appended to file: " + write_into.getAbsolutePath());
       	} catch (IOException e) {
       	    e.printStackTrace();
       	}
	           
		    Map<String,String> AadharData = new HashMap<>();
//		    AadharData.put("name", name);
//	        AadharData.put("dob", dob);
//	        AadharData.put("gender", gender);
//	        AadharData.put("mobileNumber", mobileNumber);
	        AadharData.put("adharNo", adharNo);
	        AadharData.put("vid", vid);
//	        AadharData.put("father", father); 
//	        AadharData.put("adharno1", adharno1); 
//	        AadharData.put("adharno2", adharno2); 
        
        return AadharData;

	}

}

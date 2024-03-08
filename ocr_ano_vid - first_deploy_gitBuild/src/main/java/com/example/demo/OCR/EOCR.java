package com.example.demo.OCR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.easyproject.easyocr.EasyOCR;
import cn.easyproject.easyocr.ImageType;

public class EOCR {
	//FirstName and LastName Regex

    public static Map<String, String> doEasyOCR(InputStream image,String imageType) {
	    //Regex to match string having format "dob: DD/MM/YYYY"
//  	  String nameRegex  = "([A-Z][a-z]*\\s*)([A-Z][a-z]*\\s*)*(\\s*)";			
//
//	     Pattern dob_pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
//	     String genderRegex = ".*(female|male).*";
	     String aadharRegex = "^.*\\d{4}.\\d{4}.\\d{4}(.*)$";
//	     String mobileRegex = "d{10}";
//	     String fatherRegex = "c/o: (.*)";
	     Pattern vid_pattern = Pattern.compile("\\b\\d{4}(.*)\\d{4}(.*)\\d{4}(.*)\\d{4}\\b");
	     
		String name = null,dob = null,gender = null,
				   mobileNumber=null,adharNo=null,
				   vid=null,father=null,adharno1=null,
				   adharno2=null;
		System.out.println("Inside Easy OCR");
		EasyOCR easyOCR = new EasyOCR("C:\\Users\\intern-infant\\AppData\\Local\\Programs\\Tesseract-OCR\\tesseract.exe",EasyOCR.OPTION_LANG_ENG);
        
        String text_from_image = null;
		try {
			text_from_image = easyOCR.discernAndAutoCleanImage(image,4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(imageType+" Extracted Text"+"\n"+text_from_image);
		String details[] = text_from_image.split("\n");
		for(String i: details)
        	
        {
        	String temp = i.toLowerCase();
        	
//			Matcher dob_matcher = dob_pattern.matcher(temp);
			Matcher vid_matcher = vid_pattern.matcher(temp);
        	//dob value
//        	if(dob == null && dob_matcher.find()) 
//        	{
//        		System.out.println("Inside DOB: "+temp);
//        		dob = dob_matcher.group();
//        		//dob = i.split(": ")[1];
//        		
//        	}
        	
//        	//name value
//        	if(i.matches(nameRegex) && father == null) 
//        	{
//        		name  = temp.replaceAll(nameRegex, "$1");
//        		//name = i;
//        		System.out.println("Name in if: "+name); 
//        	}
        	//gender value
//        	if(temp.matches(genderRegex)) {
//        		
//        		int startIndex;
//        		if(temp.indexOf("female")!=-1)
//        			startIndex = temp.indexOf("female");
//        		else 
//        			startIndex = temp.indexOf("male");
//        		gender  = temp.substring(startIndex,temp.lastIndexOf('e')+1);
//        	}
        	
        	//mobile NO finding
//        	if(temp.contains("mobile no: ") || temp.matches(mobileRegex)) {mobileNumber = i.split(": ")[1];}
        	
        	//aadharNo finding
        	if(temp.matches(aadharRegex) && adharNo==null ) 
        	{
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
//        		adharNo = adharNo.replaceFirst("\\d{8}", "********");
        	}

        	
        	//vid value
        	if(vid_matcher.find()) 
        	{
        		System.out.println("Inside VID: "+temp);
        		vid = vid_matcher.group();
//        		vid = i.split(" : ")[1];
        		
        	}
        	
        	//father value
//        	if(temp.matches(fatherRegex)) {
//        		System.out.println("Extract string Father: "+temp);
//        		father  =  i.split(": ")[1].split(",")[0];
//        		//father = temp.replaceAll(fatherRegex, "$1");
//        		System.out.println("Father name in if "+father);
//        		name = null;
//        	}
        	//System.out.println(temp);
        	
        }
//           System.out.println("Name: "+name+"\n"+
//                           "DOB: "+dob+"\n"+"Gender: "+gender+"\n"+
//        		           "Mobile No: "+mobileNumber+"\n"+"Aadhaar: "+adharNo+"\n"+
//                           "VID: "+vid+"\n"+"Father "+father);
		 System.out.println("Aadhaar: "+adharNo+"\n"+"VID: "+vid);
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append("Aadhaar: ").append(String.join(", ", adharNo)).append("\n")
           				.append("VID: ").append(String.join(", ", vid)).append("\n");
//           			.append("Name: ").append(String.join(", ", name)).append("\n")
//                      .append("DOB: ").append(String.join(", ", dob)).append("\n")
//                      .append("Gender: ").append(String.join(", ", gender)).append("\n")
//                      .append("Mobile No: ").append(String.join(", ", mobileNumber)).append("\n")
//                      .append("Father: ").append(String.join(", ", father));
           String result = stringBuilder.toString();
           File write_into = new File ("C:\\Users\\intern-infant\\Desktop\\Result-EasyOCR\\Result-aadhar-vid-EasyOCR.txt");
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(write_into, true))) {
        	    writer.write(imageType+" Extracted Text - EasyOCR"+"\n\n"+"File Name: "+"" +"\n\n");
        	    writer.write(result);
        	    writer.newLine();
        	    writer.newLine();

        	    System.out.println("Data has been appended to file: " + write_into.getAbsolutePath());
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}

           
	    Map<String,String> AadharData = new HashMap<>();
	   
//	    AadharData.put("name", name);
//        AadharData.put("dob", dob);
//        AadharData.put("gender", gender);
//        AadharData.put("mobileNumber", mobileNumber);
        AadharData.put("adharNo", adharNo);
        AadharData.put("vid", vid);
//        AadharData.put("father", father); 
//        AadharData.put("adharno1", adharno1); 
//        AadharData.put("adharno2", adharno2); 

 
        return AadharData;

	}


}

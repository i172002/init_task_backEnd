package com.example.demo.Pojo;

import java.util.Arrays;

public class SetDmsPostData {
	public static DmsPostData setDmsPostData(byte[] imageData,String checkSum) {
	DmsPostData dmsPostData = new DmsPostData();
	dmsPostData.setImageId("SR2021121300001124216");
    dmsPostData.setUniqueId("202112131242160001");
    dmsPostData.setAppId("20211213");
    dmsPostData.setSourceSys("CIFCL CSM CRM");
    dmsPostData.setBranchCode("CHENNAI HO");
    dmsPostData.setBranch("CHENNAI HO");
    dmsPostData.setVertical("HL");
    dmsPostData.setModule("Service_Request");
    dmsPostData.setStage("");
    dmsPostData.setImageCategory("payout_slab");
    dmsPostData.setImageSubCategory("HE");
    dmsPostData.setStatus("1");
    dmsPostData.setFileName("slab_20240207_1411.xls");
    dmsPostData.setLatLong("");
    dmsPostData.setImageSrc("Web");
    dmsPostData.setImageSrcId("202112131242160001");
    dmsPostData.setFormat("xls");
    dmsPostData.setUser("admin");
    dmsPostData.setSize("146367");
    dmsPostData.setPage("1");
    dmsPostData.setCreatedBy("admin");
    dmsPostData.setCreatedDate("07-02-2024");
    dmsPostData.setModifiedBy("admin");
    dmsPostData.setModifiedDate("07-02-2024");
    dmsPostData.setCheckSum(checkSum);
    dmsPostData.setKeyId(Arrays.asList("agreementNo", "SRnumber", "FileName", "FileType"));
    dmsPostData.setKeyValue(Arrays.asList("XSJAR00001671939", "SR2021121300", "slab_20240207_1411.xls", "xls"));
    //dmsPostData.setStatusMsg("ok");
    //dmsPostData.setStatusCode("200");
    //dmsPostData.setImagedata(imageData);
    
    return dmsPostData;

}
}

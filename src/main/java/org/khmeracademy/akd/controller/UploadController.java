package org.khmeracademy.akd.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.akd.repositories.DocumentRepository;
import org.khmeracademy.akd.services.UploadToDBService;
import org.khmeracademy.akd.services.UploadToServerService;
import org.khmeracademy.akd.services.impl.UploadFileToGoogleService;
import org.khmeracademy.akd.services.impl.UploadFolderToGoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@Autowired
	UploadToServerService fileUpload;
	
	@Autowired
	private UploadToDBService uploadToDBService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@RequestMapping(value="/api/uploadFile", method = RequestMethod.POST)
	public Map<String, Object> uploadFile(@RequestParam("files") MultipartFile file,@RequestParam("title") String title,@RequestParam("des") String des,@RequestParam("catID") String catID,@RequestParam("usreID") int userID) throws GeneralSecurityException, IOException{
		//upload file to server -> get full path
		String path = fileUpload.upload(file, null);
		int typeNum=0;
		String type=path.substring(path.lastIndexOf('.')+1,path.length());
		System.out.println("Type: "+type);
		
		if(title.endsWith(".pdf") || title.endsWith(".pptx") || title.endsWith(".ppt")){
			title=title.substring(0, title.lastIndexOf('.'));
		}
		if(type.toLowerCase().equals("ppt") || type.toLowerCase().equals("pptx")){
			typeNum=1;
		}
		else if(type.toLowerCase().equals("pdf")){
			typeNum=2;
		}
		else if(type.toLowerCase().equals("doc") || type.toLowerCase().equals("docx")){
			typeNum=3;
		}
		else{
			typeNum=0;
		}
	//	System.out.println("Type: "+type.toLowerCase());
	//	System.out.println("TypeNum: "+typeNum);
		
		if(path!=null)
		{
			UploadFileToGoogleService up=new UploadFileToGoogleService();
			uploadToDBService.uploadFile(up.upload(path,title,des,catID,typeNum,userID));	
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CODE","0000");
		map.put("MESSAGE","YOU HAVE BEEN UPLOADED SUCCESSFULLY!!!");
		map.put("DATA",path);
		return map;
	}
	
	@RequestMapping(value="/api/uploadFolder", method = RequestMethod.POST)
	public void uploadFolder(@RequestParam("folderID") String id,@RequestParam("folderName") String name,@RequestParam("folderDes") String des,@RequestParam("folderStatus") String sta ) throws GeneralSecurityException, IOException{
		System.out.println("Status: "+sta);
		UploadFolderToGoogleService folder=new UploadFolderToGoogleService();		
		boolean status=uploadToDBService.uploadFolder(folder.upload(id, name,des,sta));	
		if(status){
			//SET CODE
			//SET MESSAGE
		}
		else{
			//SET CODE
			//SET MESSAGE
		}
	}	
}

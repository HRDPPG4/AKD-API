package org.khmeracademy.akd.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/api/v1")
public class UploadController {

	@Autowired
	UploadToServerService fileUpload;
	
	@Autowired
	private UploadToDBService uploadToDBService;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@RequestMapping(value="/uploadDocument", method = RequestMethod.POST)
	public Map<String, Object> uploadFile(@RequestParam("files") List<MultipartFile> file,@RequestParam("title") List<String> title,@RequestParam("des") String des,@RequestParam("catID") String catID,@RequestParam("usreID") int userID) throws GeneralSecurityException, IOException{
		System.out.println("File length: " + file.size());
		System.out.println("Title length: " + title.size());
		String path = null;
		
		for(int i=0;i<title.size();i++){
			System.out.println("Title: "+title.get(i));
		}
		
		for(int i=0;i<file.size();i++){
			System.out.println("FileName: "+file.get(i).getOriginalFilename());
		}
		
		
	//	String fileTitles = null;
		int typeNum=0;
		String type = null;
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < file.size(); i++) {
//			fileTitles = file.get(i).getOriginalFilename();
			System.out.println();
			path = fileUpload.uploadFile(file.get(i), null);
			type=path.substring(path.lastIndexOf('.')+1,path.length());
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
			
			if(path!=null){
				UploadFileToGoogleService up=new UploadFileToGoogleService();
				uploadToDBService.uploadDocument(up.uploadDocument(path,title.get(i),des,catID,typeNum,userID));
			}
			
			
			map.put("CODE","0000");
			map.put("MESSAGE","YOU HAVE BEEN UPLOADED SUCCESSFULLY!!!");
			map.put("DATA",path);
			
			
		}
		return map;
	}
	
	@RequestMapping(value="/uploadFolder", method = RequestMethod.POST)
	public void uploadFolder(@RequestParam("folderID") String id,@RequestParam("folderName") String name,@RequestParam("folderDes") String des,@RequestParam("folderStatus") String sta,@RequestParam("catIcon") String catIcon,@RequestParam("catLevel") int catLevel,@RequestParam("catNumOrder") int catNumOrder ) throws GeneralSecurityException, IOException{
		System.out.println("Status: "+sta);
		UploadFolderToGoogleService folder=new UploadFolderToGoogleService();	
		System.out.println("Cat Level in controller: "+catLevel);
		boolean status=uploadToDBService.uploadFolder(folder.upload(id, name,des,sta,catIcon,catLevel,catNumOrder));	
		if(status){
			//SET CODE
			//SET MESSAGE
		}
		else{
			//SET CODE
			//SET MESSAGE
		}
	}
	
	
	@RequestMapping(value="/uploadUserProfile", method = RequestMethod.POST)
	public Map<String, Object> uploadUserProfile(@RequestParam("files") MultipartFile file,@RequestParam("userID") int userID) throws GeneralSecurityException, IOException{
		//upload file to server -> get full path
		String path = fileUpload.uploadUserProfile(file, null);
		System.out.println(userID);
		
		String fileName=path.substring(path.lastIndexOf('/')+1,path.length());
		System.out.println(fileName);
		
		
		if(path!=null)
		{
			uploadToDBService.uploadUserProfile(fileName,userID);	
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CODE","0000");
		map.put("MESSAGE","YOU HAVE BEEN UPLOADED SUCCESSFULLY!!!");
		map.put("DATA",path);
		return map;
	}
	
	@RequestMapping(value="/uploadDocThumbnail", method = RequestMethod.POST)
	public Map<String, Object> uploadDocThumbnail(@RequestParam("files") MultipartFile file,@RequestParam("docID") String docID) throws GeneralSecurityException, IOException{
		//upload file to server -> get full path
		String path = fileUpload.uploadDocThumbnail(file, null);
		System.out.println("DocID"+docID);
		
		String fileName=path.substring(path.lastIndexOf('/')+1,path.length());
		System.out.println("FileName"+fileName);
		String finalFilePath="http://localhost:1111/resources/img/doc-thumbnail/"+fileName;
		
		
			
		
		if(path!=null)
		{
//			uploadToDBService.uploadDocThumbnail(fileName,docID);	
			uploadToDBService.uploadDocThumbnail(finalFilePath,docID);	
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CODE","0000");
		map.put("MESSAGE","YOU HAVE BEEN UPLOADED SUCCESSFULLY!!!");
		map.put("DATA",path);
		return map;
	}		
}

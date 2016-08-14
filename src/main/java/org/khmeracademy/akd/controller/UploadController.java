package org.khmeracademy.akd.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
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
	public String uploadFile(@RequestParam("files") MultipartFile file) throws GeneralSecurityException, IOException{
		//upload file to server -> get full path
		String path = fileUpload.upload(file, null);
		System.out.println("Path is: "+path);
		

		if(path!=null)
		{
			UploadFileToGoogleService up=new UploadFileToGoogleService();
			//up.upload(path);
			
			uploadToDBService.uploadFile(up.upload(path));
			
			/*Document doc = new Document(); 
			
			System.out.println(doc.getTitle());*/
			
		//	documentRepository.insert(doc);
			
			//SET CODE
			//SET MESSAGE
		}
		
		return path;
	}
	
	@RequestMapping(value="/api/uploadFolder", method = RequestMethod.POST)
	public void uploadFolder(@RequestParam("folderID") String id,@RequestParam("folderName") String name ) throws GeneralSecurityException, IOException{
		UploadFolderToGoogleService folder=new UploadFolderToGoogleService();		
		boolean status=uploadToDBService.uploadFolder(folder.upload(id, name));	
		if(status){
			//SET CODE
			//SET MESSAGE
			
			System.out.println("folder upload successful");
		}
		else{
			//SET CODE
			//SET MESSAGE
			System.out.println("folder upload fail");
		}
	}	
}

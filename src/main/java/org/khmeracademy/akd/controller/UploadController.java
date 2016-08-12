package org.khmeracademy.akd.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.khmeracademy.akd.services.UploadService;
import org.khmeracademy.akd.services.impl.GoogleUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@Autowired
	UploadService fileUpload;
	
	@RequestMapping(value="/api/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("files") MultipartFile file) throws GeneralSecurityException, IOException{
		//upload file to server -> get full path
		String path = fileUpload.upload(file, null);
		System.out.println("Path is: "+path);
		
		GoogleUpload up=new GoogleUpload();
		up.upload(path);
		
		//SET CODE
		//SET MESSAGE
		
		return path;
	}
	
}

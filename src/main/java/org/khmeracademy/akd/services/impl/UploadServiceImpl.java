package org.khmeracademy.akd.services.impl;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.khmeracademy.akd.services.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService{

	@Override
	public String upload(MultipartFile file, String folder) {
		String filePath = null;
		if(file==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
			folder = "default";
		
		String UPLOAD_PATH = "D:/KSHRD/Resturant/" + folder;
		
		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		String fileName = file.getOriginalFilename();
		//fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		try {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
			filePath = UPLOAD_PATH + "/" + fileName;
			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return filePath;
	}

	
}

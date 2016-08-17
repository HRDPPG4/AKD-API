package org.khmeracademy.akd.services.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.khmeracademy.akd.services.UploadToServerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadToServerServiceImpl implements UploadToServerService{

	@Override
	public String upload(MultipartFile file, String folder) {
		String filePath = null;
		if(file==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
			folder = "D:/KSHRD/ALL KHMER DOCS/AKD File";
		
	//	String UPLOAD_PATH = "file" + folder;
		String UPLOAD_PATH =folder;
		
		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("File Tupe: "+fileName.substring(fileName.lastIndexOf('.')+1,fileName.length() ));
		
		//fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		
		
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

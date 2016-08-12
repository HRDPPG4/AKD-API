package org.khmeracademy.akd.services;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	
	/***
	 * Upload to default location
	 */
	public String upload(MultipartFile files, String folder);
	
	
}

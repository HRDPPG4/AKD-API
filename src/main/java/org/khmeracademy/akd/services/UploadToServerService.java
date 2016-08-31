package org.khmeracademy.akd.services;
import org.springframework.web.multipart.MultipartFile;

public interface UploadToServerService {
	
	/***
	 * Upload to default location
	 */
	public String uploadFile(MultipartFile files, String folder);
	public String uploadUserProfile(MultipartFile files, String folder);
	
}

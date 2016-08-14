package org.khmeracademy.akd.services.impl;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.drive.DriveFile;
import org.springframework.social.google.api.drive.UploadParameters;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Service
public class UploadFolderToGoogleService {
	public Category upload(String parentID,String folderName) throws GeneralSecurityException, IOException{
		//	CODE CONNECT WITH GOOGLE API
		String scope="https://www.googleapis.com/auth/drive";
		String serviceAccountID="all-khmer-docs@akd-api.iam.gserviceaccount.com";
		String ServiceAccountPrivateKey="AKD-API-3512d7454018.p12";
		
		// CODE TO DETAIL FOLDER		
		int status=1;
		
		
		
		Set<String> scopes = new HashSet<>();
		scopes.add(scope);		
        GoogleCredential googleCredential = new GoogleCredential.Builder()
			.setTransport(new NetHttpTransport())
			.setJsonFactory(JacksonFactory.getDefaultInstance())
			.setServiceAccountId(serviceAccountID)
			.setServiceAccountScopes(scopes)
			.setServiceAccountPrivateKeyFromP12File(new File(ServiceAccountPrivateKey))
			.build();
        if(googleCredential.getAccessToken()==null){
			googleCredential.refreshToken();					
		}
                
		Google google = new GoogleTemplate(googleCredential.getAccessToken());
		DriveFile folder = google.driveOperations().createFolder(parentID, folderName);
		Category cat=null;
		
		if(folder.getId()!=null && folder.getTitle()!=null){
			cat=new Category();
			cat.setCatID(folder.getId());
			cat.setCatName(folder.getTitle());
			cat.setCreatedDate(folder.getCreatedDate().toString());
			cat.setParentID(parentID);
			cat.setRemark(folder.getDescription());
			cat.setStatus(status);
		}
		
		return cat;		
	}
}

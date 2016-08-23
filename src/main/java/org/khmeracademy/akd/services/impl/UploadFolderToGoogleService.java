package org.khmeracademy.akd.services.impl;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.khmeracademy.akd.entities.Category;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.drive.DriveFile;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Service
public class UploadFolderToGoogleService {
	private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private Date d=null;
    private String date=null;
	public Category upload(String parentID,String folderName,String folderDes,String status) throws GeneralSecurityException, IOException{
		//	CODE CONNECT WITH GOOGLE API
		String scope="https://www.googleapis.com/auth/drive";
		String serviceAccountID="all-khmer-docs@akd-api.iam.gserviceaccount.com";
		String ServiceAccountPrivateKey="AKD-API-3512d7454018.p12";
		
		if(parentID==null ||parentID=="" || parentID==" "){
			parentID="0B4RhbtI4DXY_QWVOWkFiSTlRY1E";
		}
		
		
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
			d=new Date();
			date=sdf.format(d);
			cat=new Category();
			cat.setCatID(folder.getId());
			cat.setCatName(folder.getTitle());
			cat.setCreatedDate(date);
			cat.setParentID(parentID);
			cat.setRemark(folderDes);
			cat.setStatus(Integer.valueOf(status));
		}
		
		return cat;		
	}
}

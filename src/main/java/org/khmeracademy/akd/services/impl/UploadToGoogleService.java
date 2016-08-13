package org.khmeracademy.akd.services.impl;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

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
public class UploadToGoogleService {
	public Document upload(String path) throws GeneralSecurityException, IOException{
		//	CODE CONNECT WITH GOOGLE API
		String scope="https://www.googleapis.com/auth/drive";
		String serviceAccountID="all-khmer-docs@akd-api.iam.gserviceaccount.com";
		String ServiceAccountPrivateKey="AKD-API-3512d7454018.p12";
		
		// CODE TO SET DETAIL FOR FILE.
		String parentID="0B4RhbtI4DXY_QWVOWkFiSTlRY1E";
		String title="My File";
		String description="";
		boolean viewed=true;
		boolean restricted=false;
			
		
		//TODO: TO SET THE SCOPE FOR ACCESSING TO OUR GOOGLE DRIVE
		Set<String> scopes = new HashSet<>();
		scopes.add(scope);
				
		//TODO: 1. AUTHENTICATION WITH GOOGLE SERVICE ACCOUNT
        GoogleCredential googleCredential = new GoogleCredential.Builder()
									        					.setTransport(new NetHttpTransport())
									        					.setJsonFactory(JacksonFactory.getDefaultInstance())
									        					.setServiceAccountId(serviceAccountID)
									        					.setServiceAccountScopes(scopes)
									        					.setServiceAccountPrivateKeyFromP12File(new File(ServiceAccountPrivateKey))
									        					.build();
                
        System.out.println(googleCredential.refreshToken() + " " + googleCredential.getAccessToken() + " ");

        //TODO: 2. TO CREATE THE GOOGLE OBJECT WITH THE ACCESS TOKEN.
		Google google = new GoogleTemplate(googleCredential.getAccessToken());
		
		//TODO: 3. TO CREATE THE FOLDER IN GOOGLE DRIVE
		/*DriveFile folder = google.driveOperations().createFolder("0B4RhbtI4DXY_QWVOWkFiSTlRY1E", "AKD");*/
		
		//TODO: 4. TO GET THE FILE FROM THE SERVER TO UPLOAD (Create File in Google Drive.)
		Resource resource = new FileSystemResource(path);
		
		//TODO: 5. TO CREATE THE METADATA FOR FILE UPLOAD TO GOOGLE DRIVE
		
		String fileName=resource.getFilename();				
		DriveFile.Builder metaData = DriveFile.builder()
											.setTitle(title)		//fileName
											.setDescription(description)
											.setParents(parentID)
											.setViewed(viewed)
											.setRestricted(restricted);				
		
		if(fileName.endsWith(".pptx") || fileName.endsWith(".ppt")){
			 metaData.setMimeType("application/vnd.google-apps.presentation");
		}
		
		DriveFile myFile = metaData.build();
		UploadParameters parameters = new UploadParameters();
		
		//TODO: 6. TO CREATE THE FILE IN GOOGLE DRIVE
		DriveFile file1 = google.driveOperations().upload(resource, myFile, parameters);
		
		
		
		
		
		
		//System.out.println("FILE UPLOADED ===> " + file1.getThumbnailLink() + "  " + file1.getId());
		System.out.println("ID:  "+file1.getId());
		System.out.println("Description:  "+file1.getDescription());
		System.out.println("Title:  "+file1.getTitle());
		System.out.println("DownloadURL:  "+file1.getDownloadUrl());
		System.out.println("getEmbedLink:  "+file1.getEmbedLink());
		System.out.println("getEtag:  "+file1.getEtag());
		System.out.println("size:  "+file1.getFileSize());
		System.out.println("getIconLink:  "+file1.getIconLink());
		System.out.println("getLastModifyingUserName:  "+file1.getLastModifyingUserName());
		System.out.println("getMd5Checksum:  "+file1.getMd5Checksum());
		System.out.println("getMimeType:  "+file1.getMimeType());
		System.out.println("getQuotaBytesUsed:  "+file1.getQuotaBytesUsed());
		System.out.println("getSelfLink:  "+file1.getSelfLink());
		System.out.println("getThumbnailLink:  "+file1.getThumbnailLink());
		System.out.println("getCreatedDate:  "+file1.getCreatedDate());
		System.out.println("getExportLinks:  "+file1.getExportLinks());
		System.out.println("getLastViewedByMeDate:  "+file1.getLastViewedByMeDate());
		System.out.println("getOwnerNames:  "+file1.getOwnerNames());
		System.out.println("getParents:  "+file1.getParents());
		System.out.println("getUserPermission:  "+file1.getUserPermission());
		System.out.println("isFolder:  "+file1.isFolder());
		System.out.println("ThumbnailLink:  https://drive.google.com/thumbnail?authuser=0&sz=w320&id="+file1.getId());		
		System.out.println(" PPTX:		  https://docs.google.com/presentation/d/"+ file1.getId()+"/embed?start=false&loop=false&delayms=3000");
		System.out.println(" PDF:		  https://drive.google.com/file/d/"+ file1.getId()+"/preview");

		Document doc = new Document();
		
		doc.setDocID(file1.getId());
		doc.setTitle(file1.getTitle());
		doc.setDes(file1.getDescription());
		doc.setEmbedLink("free");
		doc.setThumbnailURL("https://drive.google.com/thumbnail?&sz=w320&id="+file1.getId());
		doc.setExportLink("");
		doc.setView(0);
		doc.setShare(0);
		doc.setCreatedDate(file1.getCreatedDate().toString());
		doc.setDocTypeNum(1);
		doc.setUserID(1);
		doc.setCatID(parentID);
		doc.setStatus(1);
		return doc;
		
	}
}

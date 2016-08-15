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
public class UploadFileToGoogleService {
	public Document upload(String path,String title,String description) throws GeneralSecurityException, IOException{
		//	CODE CONNECT WITH GOOGLE API
		String scope="https://www.googleapis.com/auth/drive";
		String serviceAccountID="all-khmer-docs@akd-api.iam.gserviceaccount.com";
		String ServiceAccountPrivateKey="AKD-API-3512d7454018.p12";
		
		//  CODE TO SET DETAIL FOR FILE.
		
		String parentID="0B4RhbtI4DXY_QWVOWkFiSTlRY1E";
		
		
		//String title="My File";
		//String description="";
		boolean viewed=true;
		boolean restricted=false;
		String embedLink=null;
		int doctype=1;				//default
		int userID=1;				//default
		int status=1;				//default

									
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
        if(googleCredential.getAccessToken()==null){
			googleCredential.refreshToken();					
		}
                
       // System.out.println(googleCredential.refreshToken() + " " + googleCredential.getAccessToken() + " ");

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
		

	
		System.out.println("getEmbedLink:  "+file1.getEmbedLink());
		System.out.println("size:  "+file1.getFileSize());

		System.out.println("getMimeType:  "+file1.getMimeType());
		System.out.println("getExportLinks:  "+file1.getExportLinks());
		
		System.out.println("isFolder:  "+file1.isFolder());	
		
		
		if(fileName.toLowerCase().endsWith(".pptx") || fileName.toLowerCase().endsWith(".ppt")){
			embedLink="https://docs.google.com/presentation/d/"+ file1.getId()+"/embed?start=false&loop=false&delayms=3000";
		}
		
		if(fileName.toLowerCase().endsWith(".pdf")){
			embedLink="https://drive.google.com/file/d/"+ file1.getId()+"/preview";
		}

		Document doc = new Document();
		
		doc.setDocID(file1.getId());
		doc.setTitle(file1.getTitle());
		doc.setDes(file1.getDescription());
		doc.setEmbedLink(embedLink);
		doc.setThumbnailURL("https://drive.google.com/thumbnail?&sz=w320&id="+file1.getId());
		doc.setExportLink("");
		doc.setView(0);
		doc.setShare(0);
		doc.setCreatedDate(file1.getCreatedDate().toString());
		doc.setDocTypeNum(doctype);
		doc.setUserID(userID);
		doc.setCatID(parentID);
		doc.setStatus(status);
		return doc;
		
	}
}

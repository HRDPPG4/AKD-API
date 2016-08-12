package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.repositories.DocumentRepository;
import org.khmeracademy.akd.services.UploadToDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadToDBServiceImpl implements UploadToDBService{
	
	@Autowired
	private DocumentRepository documentRepository;
	

	@Override
	public boolean uploadFile(Document doc) {
		return documentRepository.insert(doc);
		
	}

	@Override
	public boolean uploadFolder(Category cat) {
		// TODO Auto-generated method stub
		return false;
	}



	
}

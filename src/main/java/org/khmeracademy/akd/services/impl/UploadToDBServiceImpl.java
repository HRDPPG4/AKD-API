package org.khmeracademy.akd.services.impl;
import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.repositories.CategoryRepository;
import org.khmeracademy.akd.repositories.DocumentRepository;
import org.khmeracademy.akd.services.UploadToDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadToDBServiceImpl implements UploadToDBService{	
	@Autowired
	private DocumentRepository documentRepository;	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public boolean uploadFile(Document doc) {
		return documentRepository.insert(doc);		
	}

	@Override
	public boolean uploadFolder(Category cat) {
		return categoryRepository.insert(cat);
	}
}

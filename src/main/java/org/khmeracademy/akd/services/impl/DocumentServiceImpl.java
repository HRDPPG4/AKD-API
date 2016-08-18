package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.repositories.DocumentRepository;
import org.khmeracademy.akd.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	@Override
	public boolean delete(String id) {
		try{
			return documentRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Document doc) {
		
		return documentRepository.insert(doc);
		
	}

	@Override
	public boolean update(Document doc) {
		return documentRepository.update(doc);
	}

	@Override
	public ArrayList findAll() {
		return documentRepository.findAll();
	}
	
	@Override
	public ArrayList getDocumentByCatID(String CatID) {
		return documentRepository.getDocumentByCatID(CatID);
	}
	
	

	@Override
	public Document findOne(String id) {
		return documentRepository.findOne(id);
	}

	
}

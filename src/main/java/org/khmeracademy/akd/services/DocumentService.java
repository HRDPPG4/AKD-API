package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;

public interface DocumentService {	
	boolean delete(String id);
	
	boolean insert(Document doc);
	
	boolean update(Document doc);
	
	ArrayList<Object> findAll();
	
	ArrayList<Document> getDocumentByCatID(String CatID);
	
	Document findOne(String id);
	
}

package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.utilities.Paging;

public interface DocumentService {	
	boolean delete(String id);
	
	boolean insert(Document doc);
	
	boolean update(Document doc);
	
	ArrayList<Object> findAll(Paging pagination);
	
	ArrayList<Document> getDocumentByCatID(String CatID);
	
	Document findOne(String id);
	
	ArrayList<Document> getDocumentAndUserAndCategoryAndCommentByDocID(String DocID);
	
	ArrayList<Document> getDocumentByPopular();
	
	ArrayList<Document> getDocumentByRecommended();
	
	ArrayList<Document> getDocumentByNewPost();
	
	int getDocumentCount();
	
	
	
	
}

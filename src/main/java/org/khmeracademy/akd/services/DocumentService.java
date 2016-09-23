package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.utilities.Paging;

public interface DocumentService {	
	boolean delete(String id);
	
	boolean insert(Document doc);
	
	boolean update(Document doc);
	
	boolean countView(String docID);
	
	ArrayList<Object> findAll();
	
	ArrayList<Document> getDocumentByCatID(String CatID);
	
	ArrayList<Document> getDocByUser(int userID, int docTypeNum);
	
	
	Document findOne(String id);
	
	ArrayList<Document> getDocumentAndUserAndCategoryAndCommentByDocID(String DocID);
	
	ArrayList<Document> getDocumentByPopular(Paging pagination);
	
	ArrayList<Document> getDocumentByRecommended(int userID);
	
	ArrayList<Document> getDocumentByNewPost();
	
	int getDocumentCount();
	
	ArrayList<Document> getDocumentByLikeTitle(String title);

	/*int getDocumentCountByCatID(String catID);*/

	boolean updateTotalDocByCatID(String catID);


	
	
	
	
	
	
	
}

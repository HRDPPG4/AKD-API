package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.repositories.DocumentRepository;
import org.khmeracademy.akd.services.DocumentService;
import org.khmeracademy.akd.utilities.Paging;
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
		return documentRepository.getDocumentAndUserAndCategory();
	}
	
	
	
	@Override
	public ArrayList getDocumentByCatID(String CatID) {
		return documentRepository.getDocumentByCatID(CatID);
	}
	
	

	@Override
	public Document findOne(String id) {
		return documentRepository.findOne(id);
	}
	
	@Override
	public ArrayList getDocumentAndUserAndCategoryAndCommentByDocID(String DocID) {
		return documentRepository.getDocumentAndUserAndCategoryAndComment(DocID);
	}

	
	
	@Override
	public ArrayList getDocumentByPopular(Paging pagination) {
		pagination.setTotalCount(documentRepository.count());
		return documentRepository.getDocumentByPopular(pagination);
	}
	
	@Override
	public ArrayList getDocumentByRecommended() {
		return documentRepository.getDocumentByRecommended();
	}
	
	
	@Override
	public int getDocumentCount() {
		return documentRepository.getDocumentCount();
	}

	
	
	@Override
	public ArrayList getDocumentByLikeTitle(String title) {
		return documentRepository.getDocumentByLikeTitle(title);
	}
	

	


	@Override
	public ArrayList<Document> getDocByUser(int userID, int docTypeNum) {
		System.out.println("USER ID==> " + userID + " DOCTYPE NUM ==> "+ docTypeNum);
		return documentRepository.getDocByUser(userID, docTypeNum);
	}

	@Override
	public boolean countView(String docID) {
		// TODO Auto-generated method stub
		return  documentRepository.countView(docID);
	}

	@Override
	public ArrayList<Document> getDocumentByNewPost() {
		// TODO Auto-generated method stub
		return documentRepository.getDocumentByNewPost();
	}

	


	

	
}

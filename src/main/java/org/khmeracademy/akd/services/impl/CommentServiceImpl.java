package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.repositories.CommentRepository;
import org.khmeracademy.akd.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	@Override
	public boolean delete(int id) {
		try{
			return commentRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Comment com) {
		
		return commentRepository.insert(com);
		
	}

	@Override
	public boolean update(Comment com) {
		return commentRepository.update(com);
	}

	@Override
	public ArrayList findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findOne(int id) {
		return commentRepository.findOne(id);
	}
	
	@Override
	public ArrayList getAllCommentByDocID(String DocID) {
		return commentRepository.getAllCommentByDocID(DocID);
	}
	
	
}

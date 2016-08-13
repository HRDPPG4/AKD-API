package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Comment;
public interface CommentService {	
	boolean delete(int id);
	
	boolean insert(Comment com);
	
	boolean update(Comment com);
	
	ArrayList<Object> findAll();
	
	Comment findOne(int id);
	
}

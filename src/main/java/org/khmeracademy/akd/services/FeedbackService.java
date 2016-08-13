package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Feedback;
public interface FeedbackService {	
	boolean delete(int id);
	
	boolean insert(Feedback feed);
	
	boolean update(Feedback feed);
	
	ArrayList<Object> findAll();
	
	Feedback findOne(int id);
	
}

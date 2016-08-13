package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Feedback;
import org.khmeracademy.akd.repositories.FeedbackRepository;
import org.khmeracademy.akd.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	@Override
	public boolean delete(int id) {
		try{
			return feedbackRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Feedback feed) {
		
		return feedbackRepository.insert(feed);
		
	}

	@Override
	public boolean update(Feedback feed) {
		return feedbackRepository.update(feed);
	}

	@Override
	public ArrayList findAll() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback findOne(int id) {
		return feedbackRepository.findOne(id);
	}

	
}

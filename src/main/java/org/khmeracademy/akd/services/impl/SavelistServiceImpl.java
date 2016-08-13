package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.repositories.SavelistRepository;
import org.khmeracademy.akd.services.SavelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavelistServiceImpl implements SavelistService{
	
	@Autowired
	private SavelistRepository savelistRepository;
	
	
	@Override
	public boolean delete(int id) {
		try{
			return savelistRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Savelist list) {
		
		return savelistRepository.insert(list);
		
	}

	@Override
	public boolean update(Savelist list) {
		return savelistRepository.update(list);
	}

	@Override
	public ArrayList findAll() {
		return savelistRepository.findAll();
	}

	@Override
	public Savelist findOne(int id) {
		return savelistRepository.findOne(id);
	}

	
}

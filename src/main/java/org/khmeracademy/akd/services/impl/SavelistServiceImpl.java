package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;

import org.apache.felix.bundlerepository.impl.SystemRepositoryImpl;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.repositories.SavelistRepository;
import org.khmeracademy.akd.services.SavelistService;
import org.khmeracademy.akd.utilities.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		savelistRepository.insert(list);
		
		return savelistRepository.insertDetails(list);
	}

	@Override
	public boolean update(Savelist list) {
		return savelistRepository.update(list);
	}

	@Override
	public ArrayList findAll(Paging pagination) {
		pagination.setTotalCount(savelistRepository.count());
		return savelistRepository.findAll(pagination);
	}

	@Override
	public Savelist findOne(int id) {
		return savelistRepository.findOne(id);
	}

	@Override
	public ArrayList<Savelist> findSavelistByUserID(int userID) {
		return savelistRepository.findSavelistByUserID(userID);
	
	
	}

	@Override
	public boolean insertDetail(Savelist list) {
		return savelistRepository.insertDetails(list);
	}

	@Override
	public boolean insertSavelistOnly(Savelist list) {
		
		return savelistRepository.insertSavelistOnly( list );
	}

	
}

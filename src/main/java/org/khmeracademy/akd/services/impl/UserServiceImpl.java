package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Userss;
import org.khmeracademy.akd.repositories.UserRepository;
import org.khmeracademy.akd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean delete(int id) {
		try{
			return userRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Userss user) {
		
		return userRepository.insert(user);
		
	}

	@Override
	public boolean update(Userss user) {
		return userRepository.update(user);
	}

	@Override
	public ArrayList<Userss> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Userss findOne(int id) {
		return userRepository.findOne(id);
	}

	
}

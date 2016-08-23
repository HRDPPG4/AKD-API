package org.khmeracademy.akd.services.impl;
import java.util.ArrayList;

import org.khmeracademy.akd.entities.User;
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
	public boolean insert(User user) {
		
		return userRepository.insert(user);
		
	}

	@Override
	public boolean update(User user) {
		return userRepository.update(user);
	}

	@Override
	public ArrayList findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public int getUserCount() {
		return userRepository.getUserCount();
	}

	
}

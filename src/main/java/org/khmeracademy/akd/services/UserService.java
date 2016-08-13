package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.User;
public interface UserService {	
	boolean delete(int id);
	
	boolean insert(User user);
	
	boolean update(User user);
	
	ArrayList<Object> findAll();
	
	User findOne(int id);
	
}

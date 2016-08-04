package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Userss;


public interface UserService {
	/***
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	
	boolean insert(Userss user);
	
	boolean update(Userss user);
	
	ArrayList<Userss> findAll();
	
	Userss findOne(int id);
	
}

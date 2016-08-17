package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Category;
public interface CategoryService {	
	boolean delete(String id);
	
	boolean insert(Category cat);
	
	boolean update(Category cat);
	
	ArrayList<Object> findAll();
	ArrayList<Object> getCategoryByParentID(String ParentID);
	
	Category findOne(String id);
	
}

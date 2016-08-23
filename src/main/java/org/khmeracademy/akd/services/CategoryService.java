package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Category;
public interface CategoryService {	
	boolean delete(String id);
	
	boolean insert(Category cat);
	
	boolean update(Category cat);
	
	Category findOne(String id);
	
	ArrayList<Object> findAll();
	
	ArrayList<Object> getCategoryByParentID(String ParentID);
	
	/*ArrayList<Category> getCategoryByParentIDAndStatus(String ParentID,int Status);*/
	
	ArrayList<Category> getCategoryByParentIDAndStatusEnable(String ParentID);
	
	int getCategoryCount();
	
}

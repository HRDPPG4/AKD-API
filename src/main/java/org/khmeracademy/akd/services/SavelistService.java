package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.utilities.Paging;
public interface SavelistService {	
	boolean delete(int id);
	
	boolean insert(Savelist list);
	
	boolean update(Savelist list);
	boolean insertDetail(Savelist list);
	boolean insertSavelistOnly(Savelist list);
	
	ArrayList<Object> findAll(Paging pagination);
	
	ArrayList<Savelist> findSavelistByUserID(int userID);
	
	Savelist findOne(int id);
	
}

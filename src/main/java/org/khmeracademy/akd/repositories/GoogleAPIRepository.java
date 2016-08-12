package org.khmeracademy.akd.repositories;

import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleAPIRepository {
		
	//@Insert("INSERT INTO tbl_user(name, gender,email) VALUES(#{name}, #{gender},#{email})")
	boolean uploadFile(Document doc);
	
	//@Insert("INSERT INTO tbl_user(name, gender,email) VALUES(#{name}, #{gender},#{email})")
	boolean uploadFolder(Category cat);
	
	
}

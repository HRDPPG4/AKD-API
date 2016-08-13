package org.khmeracademy.akd.repositories;

import java.util.ArrayList;





import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {
	
	@Delete("DELETE FROM akd_categories WHERE cat_id=#{catID}")
	boolean delete(String id);
	@Update("UPDATE akd_categories SET name=#{catName},created_date=#{createdDate},remark=#{remark},parent_id=#{parentID},status=#{status} WHERE cat_id=#{catID}")
	boolean update(Category cat);
	
	@Insert("INSERT INTO akd_categories (cat_id,name,created_date,remark ,parent_id,status) VALUES(#{catID},#{catName},#{createdDate},#{remark},#{parentID},#{status})")
	boolean insert(Category cat);
	
	
	@Select("SELECT * FROM akd_categories")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status")
			
	})
	ArrayList<Category>findAll();
	
	@Select("SELECT * from akd_categories WHERE cat_id=#{catID}")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status")
			
	})
	Category findOne(String id);
	
}

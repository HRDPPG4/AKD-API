package org.khmeracademy.akd.repositories;

import java.util.ArrayList;







import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
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
	@Update("UPDATE akd_categories SET name=#{catName},created_date=#{createdDate},remark=#{remark},parent_id=#{parentID},status=#{status},icon=#{icon} WHERE cat_id=#{catID}")
	boolean update(Category cat);
	
	@Insert("INSERT INTO akd_categories (cat_id,name,created_date,remark ,parent_id,status,icon) VALUES(#{catID},#{catName},#{createdDate},#{remark},#{parentID},#{status},#{icon})")
	boolean insert(Category cat);
	
	
	@Select("SELECT * FROM akd_categories")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon")
	})
	ArrayList<Category>findAll();
	
	@Select("SELECT * from akd_categories WHERE cat_id=#{catID}")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon")
			
	})
	Category findOne(String id);
	
	@Select("SELECT * FROM akd_categories WHERE parent_id=#{parentID} AND status=1")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon"),
		@Result(property="subCategories", column="cat_id"  
			, many = @Many(select = "getCategoryByParentIDAndStatusEnable")
		)
	})
	ArrayList<Category>getCategoryByParentID(String ParentID);
	
	/*@Select("SELECT * FROM akd_categories WHERE parent_id=#{parent_id} AND status=1 ")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon")
			
	})
	ArrayList<Category>getCategoryByParentIDAndStatus(@Param("parent_id")String ParentID, @Param("status")int Status);*/
	
	@Select("SELECT * FROM akd_categories WHERE parent_id=#{parentID} AND status=1")
	@Results({
		@Result(property="catID", column="cat_id"),
		@Result(property="catName", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="parentID", column="parent_id"),
		@Result(property="status", column="status"),
		@Result(property="icon", column="icon")
			
	})
	ArrayList<Category>getCategoryByParentIDAndStatusEnable(String ParentID);
	
}

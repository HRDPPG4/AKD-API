package org.khmeracademy.akd.repositories;

import java.util.ArrayList;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	@Delete("DELETE FROM tbl_user WHERE id=#{id}")
	boolean delete(int id);
	@Update("UPDATE tbl_user SET name=#{name},gender=#{gender},email=#{email} WHERE id=#{id}")
	boolean update(User user);
	
	@Insert("INSERT INTO tbl_user(name, gender,email) VALUES(#{name}, #{gender},#{email})")
	boolean insert(User user);
	
	
	@Select("SELECT id, name, gender,email FROM tbl_user ORDER BY id DESC")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="gender", column="gender"),
		@Result(property="email", column="email")
	})
	ArrayList<User> findAll();
	
	@Select("SELECT id, name, gender,email FROM tbl_user WHERE id=#{id} ORDER BY id DESC ")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="gender", column="gender"),
		@Result(property="email", column="email")
	})
	User findOne(int id);
	
}

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
	
	@Delete(USER_SQL.DELETE)
	boolean delete(int id);
	
	@Update(USER_SQL.UPDATE)
	boolean update(User user);
	
	@Insert(USER_SQL.INSERT)
	boolean insert(User user);
	
	
	@Select(USER_SQL.SELECT)
	@Results({
		@Result(property="userID", column="user_id"),
		@Result(property="name", column="name"),
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
		@Result(property="phone", column="phone"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="status", column="status"),		
		@Result(property="role", column="role")		
	})
	ArrayList<User> findAll();
	
	@Select(USER_SQL.FIND_ONE)
	@Results({
		@Result(property="userID", column="user_id"),
		@Result(property="name", column="name"),
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
		@Result(property="phone", column="phone"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="status", column="status"),		
		@Result(property="role", column="role")
	})
	User findOne(int id);
	
}

interface USER_SQL{
	String SELECT="SELECT * from akd_users";
	
	String FIND_ONE="SELECT * from akd_users WHERE user_id=#{userID}";
	
	String DELETE="DELETE FROM akd_users WHERE user_id=#{userID}";
	
	String UPDATE="UPDATE akd_users SET "
			+ "name=#{name},"
			+ "password=#{password},"
			+ "email=#{email},"
			+ "phone=#{phone},"
			+ "created_date=#{createdDate}, "
			+ "remark=#{remark},"
			+ "status=#{status},"
			+ "role=#{role}"
			+ "WHERE user_id=#{userID}";
	
	String INSERT="INSERT INTO "
			+ "akd_users(user_id,"
			+ "name,"
			+ "password,email,phone,created_date,remark,status,role)"
			+ "VALUES"
			+ "(#{userID},"
			+ "#{name},"
			+ "#{password},"
			+ "#{email},"
			+ "#{phone},"
			+ "#{createdDate},"
			+ "#{remark},"
			+ "#{status},"
			+ "#{role})";	
}



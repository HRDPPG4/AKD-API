package org.khmeracademy.akd.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.User;
import org.khmeracademy.akd.utilities.Paging;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	@Delete(USER_SQL.DELETE)
	boolean delete(int id);
	
	@Update(USER_SQL.UPDATE)
	boolean update(User user);
	
	@Insert(USER_SQL.INSERT)
	boolean insert(User user);
	
	@Select(USER_SQL.COUNT)
	public Long count();
	
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
	ArrayList<User> findAll(@Param("pagination") Paging pagination);
	
	
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
	
	@Select("SELECT COUNT(*) FROM akd_users")
	
	@Results({
		@Result(property="userID", column="count"),
	})
	int getUserCount();
	
}

interface USER_SQL{
//	String SELECT="SELECT * from akd_users ORDER BY user_id ASC";
	
	String SELECT="SELECT * from akd_users ORDER BY user_id ASC LIMIT #{pagination.limit} OFFSET #{pagination.offset}";
	
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
			+ "akd_users("
			+ "name,"
			+ "password,email,phone,created_date,remark,status,role)"
			+ "VALUES("
			+ "#{name},"
			+ "#{password},"
			+ "#{email},"
			+ "#{phone},"
			+ "#{createdDate},"
			+ "#{remark},"
			+ "#{status},"
			+ "#{role})";	
	
	String COUNT="SELECT COUNT(user_id) FROM akd_users";
}



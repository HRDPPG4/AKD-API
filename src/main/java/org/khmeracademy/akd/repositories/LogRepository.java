package org.khmeracademy.akd.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository {
	
	@Delete("DELETE FROM akd_logs WHERE log_id=#{logID}")
	boolean delete(int id);
	@Update("UPDATE akd_logs SET date=#{date},remark=#{remark},user_id=#{userID},doc_id=#{docID},status=#{status} WHERE log_id=#{logID}")
	boolean update(Log feed);
	
	@Insert("INSERT INTO akd_logs(date,remark,user_id,doc_id,status) VALUES(#{date},#{remark},#{userID},#{docID},#{status})")
	boolean insert(Log feed);
	
	
	@Select("SELECT * from akd_logs")
	@Results({
		@Result(property="logID", column="log_id"),
		@Result(property="date", column="date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")
		
	})
	ArrayList<Log> findAll();
	
	@Select("SELECT * from akd_logs WHERE log_id=#{logID}")
	@Results({
		@Result(property="logID", column="log_id"),
		@Result(property="date", column="date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")
	})
	Log findOne(int id);
	
}

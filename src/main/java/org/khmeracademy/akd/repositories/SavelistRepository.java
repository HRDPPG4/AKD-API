package org.khmeracademy.akd.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Savelist;
import org.springframework.stereotype.Repository;

@Repository
public interface SavelistRepository {
	
	@Delete(SAVE_LIST_SQL.DELETE)
	boolean delete(int id);

	@Update(SAVE_LIST_SQL.UPDATE)
	boolean update(Savelist list);
	
	@Insert(SAVE_LIST_SQL.INSERT)
	boolean insert(Savelist list);
	
	
	@Select(SAVE_LIST_SQL.SELECT)
	@Results({
		@Result(property="savelistID", column="save_list_id"),
		@Result(property="name", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")	
	})
	ArrayList<Savelist> findAll();
	
	@Select(SAVE_LIST_SQL.FIND_ONE)
	@Results({
		@Result(property="savelistID", column="save_list_id"),
		@Result(property="name", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")	
	})
	Savelist findOne(int id);
	
}

interface SAVE_LIST_SQL{
	String SELECT="SELECT * from akd_save_lists";
	
	String FIND_ONE="SELECT * from akd_save_lists WHERE save_list_id=#{savelistID}";
	
	String DELETE="DELETE FROM akd_save_lists WHERE save_list_id=#{savelistID}";
	
	String UPDATE="UPDATE akd_save_lists SET "
			+ "name=#{name},"
			+ "created_date=#{createdDate},"
			+ "remark=#{remark},"
			+ "user_id=#{userID},"
			+ "doc_id=#{docID}, "
			+ "status=#{status}"
			+ "WHERE save_list_id=#{savelistID}";
	
	String INSERT="INSERT INTO "
			+ "akd_save_lists(save_list_id,"
			+ "name,"
			+ "created_date,remark,user_id,doc_id,status)"
			+ "VALUES"
			+ "(#{savelistID},"
			+ "#{name},"
			+ "#{createdDate},"
			+ "#{remark},"
			+ "#{userID},"
			+ "#{docID},"
			+ "#{status})";
}






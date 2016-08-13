package org.khmeracademy.akd.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Log;
import org.khmeracademy.akd.entities.Report;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository {
	@Delete(REPORT_SQL.DELETE)
	boolean delete(int id);
	
	@Update(REPORT_SQL.UPDATE)
	boolean update(Report rep);
	
	@Insert(REPORT_SQL.INSERT)
	boolean insert(Report rep);
	
	
	@Select(REPORT_SQL.SELECT)
	@Results({
		@Result(property="reportID", column="report_id"),
		@Result(property="date", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")	
	})
	ArrayList<Report> findAll();
	
	@Select(REPORT_SQL.FIND_ONE)
	@Results({
		@Result(property="reportID", column="report_id"),
		@Result(property="date", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")	
	})
	Report findOne(int id);
	
}

interface REPORT_SQL{
	String SELECT="SELECT * from akd_reports";
	
	String FIND_ONE="SELECT * from akd_reports WHERE report_id=#{reportID}";
	
	String DELETE="DELETE FROM akd_reports WHERE report_id=#{reportID}";
	
	String UPDATE="UPDATE akd_reports SET "
			+ "created_date=#{date},"
			+ "remark=#{remark},"
			+ "user_id=#{userID},"
			+ "doc_id=#{docID},"
			+ "status=#{status} "
			+ "WHERE report_id=#{reportID}";
	
	String INSERT="INSERT INTO "
			+ "akd_reports(report_id,"
			+ "created_date,"
			+ "remark,"
			+ "user_id,"
			+ "doc_id,status)"
			+ "VALUES"
			+ "(#{reportID},"
			+ "#{date},"
			+ "#{remark},"
			+ "#{userID},"
			+ "#{docID},"
			+ "#{status})";	
}





package org.khmeracademy.akd.repositories;

import java.util.ArrayList;




import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Document;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository {
	
	@Delete("DELETE FROM akd_documents WHERE doc_id=#{docID}")
	boolean delete(String id);
	@Update("UPDATE akd_documents SET title=#{title},des=#{des},embed_link=#{embedLink},thumbnail_url=#{thumbnailURL},export_link=#{exportLink},view=#{view},share=#{share},created_date=#{createdDate},doc_type_num=#{docTypeNum},user_id=#{userID},cat_id=#{catID},status=#{status} WHERE doc_id=#{docID}")
	boolean update(Document doc);
	
	@Insert("INSERT INTO akd_documents VALUES(#{docID},#{title},#{des},#{embedLink},#{thumbnailURL},#{exportLink},#{view},#{share},#{createdDate},#{docTypeNum},#{userID},#{catID},#{status})")
	boolean insert(Document doc);
	
	
	@Select("SELECT * from akd_documents")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status")		
	})
	ArrayList<Document> findAll();
	
	@Select("SELECT * from akd_documents WHERE doc_id=#{docID}")
	@Results({
		@Result(property="docID", column="doc_id"),
		@Result(property="title", column="title"),
		@Result(property="des", column="des"),
		@Result(property="embedLink", column="embed_link"),
		@Result(property="thumbnailURL", column="thumbnail_url"),
		@Result(property="exportLink", column="export_link"),
		@Result(property="view", column="view"),
		@Result(property="share", column="share"),		
		@Result(property="createdDate", column="created_date"),
		@Result(property="docTypeNum", column="doc_type_num"),
		@Result(property="userID", column="user_id"),
		@Result(property="catID", column="cat_id"),
		@Result(property="status", column="status")	
	})
	Document findOne(String id);
	
}

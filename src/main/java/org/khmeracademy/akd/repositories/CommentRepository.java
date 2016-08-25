package org.khmeracademy.akd.repositories;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.utilities.Paging;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository {
	
	@Delete("DELETE FROM akd_comments WHERE comment_id=#{commentID}")
	boolean delete(int id);
	@Update("UPDATE akd_comments SET created_date=#{createdDate},remark=#{remark},user_id=#{userID},doc_id=#{docID},status=#{status} WHERE comment_id =#{commentID}")
	boolean update(Comment com);
	
	@Insert("INSERT INTO akd_comments(created_date,remark,user_id,doc_id,status)VALUES(#{createdDate},#{remark},#{userID},#{docID},#{status})")
	boolean insert(Comment com);
	
	@Select("SELECT COUNT(comment_id) from akd_comments")
	public Long count();
	
	@Select("SELECT * from akd_comments ORDER BY comment_id ASC LIMIT #{pagination.limit} OFFSET #{pagination.offset}")
	@Results({
		@Result(property="commentID", column="comment_id"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")
			
	})
	ArrayList<Comment> findAll(@Param("pagination") Paging pagination);
	
	@Select("SELECT * from akd_comments WHERE comment_id=#{commentID}")
	@Results({
		@Result(property="commentID", column="comment_id"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")	
	})
	Comment findOne(int id);
	
	@Select("SELECT * from akd_comments WHERE doc_id=#{docID} ORDER BY comment_id DESC")
	@Results({
		@Result(property="commentID", column="comment_id"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status")
			
	})
	ArrayList<Comment> getAllCommentByDocID(String DocID);
	
}

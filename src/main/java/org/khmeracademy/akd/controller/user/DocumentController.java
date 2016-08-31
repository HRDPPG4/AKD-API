package org.khmeracademy.akd.controller.user;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.response.Response;
import org.khmeracademy.akd.response.ResponseCode;
import org.khmeracademy.akd.response.ResponseList;
import org.khmeracademy.akd.response.ResponseObject;
import org.khmeracademy.akd.services.DocumentService;
import org.khmeracademy.akd.utilities.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value="/document",method=RequestMethod.GET)
	public ResponseList<Document> findAll()
	{
		ArrayList<Object> doc=documentService.findAll();
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.findAll()!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		return res;
	}
	
	@RequestMapping(value="/document/{id}",method=RequestMethod.GET)
	public ResponseObject<Document> fineOne(@PathVariable("id") String id)
	{
		Document doc=documentService.findOne(id);
		ResponseObject<Document> res=new ResponseObject<Document>();
		if(documentService.findOne(id)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	
	}
	
	@RequestMapping(value="/document/user/{userID}",method=RequestMethod.GET)
	public ResponseObject<Document> getDocByUser(@PathVariable("userID") int userID, @RequestParam(value="docTypeNum", defaultValue="2") int docTypeNum)
	{
		ArrayList<Document> doc=documentService.getDocByUser(userID,docTypeNum);
		ResponseObject<Document> res=new ResponseObject<Document>();
		if(documentService.getDocByUser(userID,docTypeNum)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/document/{id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id)
	{
	
		boolean status=documentService.delete(id);
		Response res=new Response();
		if(status){
			res.setCode(ResponseCode.DELETE_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.DELETE_FAIL);
			res.setMessage();
		}
		return res;
	}
	
	
	
	@RequestMapping(value="/document",method=RequestMethod.POST)
	public Response insert(@RequestBody Document doc)
	{
		Response res=new Response();
		if(documentService.insert(doc)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage();
		}
		
		return res;
		
	}

	
	
	@RequestMapping(value="/document",method=RequestMethod.PUT)
	public Response update(@RequestBody Document doc)
	{
		Response res=new Response();
		
		if(documentService.update(doc))
		{
			res.setCode(ResponseCode.UPDATE_SUCCESS);
			res.setMessage();
		}
		else
		{
			res.setCode(ResponseCode.UPDATE_FAIL);
			res.setMessage();
		}
	
		return res;
	}
	
	@RequestMapping(value="/document/counview/{docID}",method=RequestMethod.PUT)
	public Response countView(@PathVariable("docID") String docID)
	{
		
		System.out.println(docID);
		Response res = new Response();
		if(documentService.countView(docID)){
			res.setCode(ResponseCode.UPDATE_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.UPDATE_FAIL);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/getDocumentByCatID/{CatID}",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentByCatID(@PathVariable("CatID") String CatID)
	{
		ArrayList<Document> doc=documentService.getDocumentByCatID(CatID);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentByCatID(CatID)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	@RequestMapping(value="/getDocDetail/{DocID}",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentAndUserAndCategoryAndCommentByDocID(@PathVariable("DocID") String DocID)
	{
		ArrayList<Document> doc=documentService.getDocumentAndUserAndCategoryAndCommentByDocID(DocID);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentAndUserAndCategoryAndCommentByDocID(DocID)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	@RequestMapping(value="/getDocumentByPopular/",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentByPopular(Paging pagination)
	{
		ArrayList<Document> doc=documentService.getDocumentByPopular(pagination);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentByPopular(pagination)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
			res.setPaging(pagination);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	@RequestMapping(value="/getDocumentByRecommended/{userID}",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentByRecommended(@PathVariable("userID") int userID)
	{
		ArrayList<Document> doc=documentService.getDocumentByRecommended(userID);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentByRecommended(userID)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	@RequestMapping(value="/getDocumentByNewPost/",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentByNewPost()
	{
		ArrayList<Document> doc=documentService.getDocumentByNewPost();
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentByNewPost()!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		return res;
		
	}
	
	@RequestMapping(value="/getDocumentCount",method=RequestMethod.GET)
	public Response getDocumentCount()
	{
		int count =documentService.getDocumentCount();
		Response res=new Response();
		if(documentService.getDocumentCount()!=0){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setCount(count);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/getDocumentByLikeTitle/{Title}",method=RequestMethod.GET)
	public ResponseList<Document> getDocumentByLikeTitle(@PathVariable("Title") String title)
	{
		ArrayList<Document> doc=documentService.getDocumentByLikeTitle(title);
		ResponseList<Document> res=new ResponseList<Document>();
		
		if(documentService.getDocumentByLikeTitle(title)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	
	
}

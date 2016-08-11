package org.khmeracademy.akd.controller.user;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.response.*;
import org.khmeracademy.akd.services.DocumentService;
import org.khmeracademy.akd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	
//	@RequestMapping(value="/document/{id}",method=RequestMethod.GET)
//	public ResponseObject<Userss> fineOne(@PathVariable("id") int id)
//	{
//		Userss user=documentService.findOne(id);
//		ResponseObject<Userss> res=new ResponseObject<Userss>();
//		if(documentService.findOne(id)!=null){
//			res.setCode(ResponseCode.RECORD_FOUND);
//			res.setMessage();
//			res.setData(user);
//		}
//		else{
//			res.setCode(ResponseCode.RECORD_NOT_FOUND);
//			res.setMessage();
//		}
//		
//		return res;
//	}
//	
//	
//	@RequestMapping(value="/document/{id}",method=RequestMethod.DELETE)
//	public Response delete(@PathVariable("id") int id)
//	{
//	
//		boolean status=documentService.delete(id);
//		Response res=new Response();
//		if(status){
//			res.setCode(ResponseCode.DELETE_SUCCESS);
//			res.setMessage();
//		}
//		else{
//			res.setCode(ResponseCode.DELETE_FAIL);
//			res.setMessage();
//		}
//		return res;
//	}
//	
//	
//	
//	@RequestMapping(value="/document",method=RequestMethod.POST)
//	public Response insert(@RequestBody Userss user)
//	{
//		Response res=new Response();
//		if(documentService.insert(user)){
//			res.setCode(ResponseCode.INSERT_SUCCESS);
//			res.setMessage();
//		}
//		else{
//			res.setCode(ResponseCode.INSERT_FAIL);
//			res.setMessage();
//		}
//		
//		return res;
//		
//	}
//
//	
//	
//	@RequestMapping(value="/document",method=RequestMethod.PUT)
//	public Response update(@RequestBody Userss user)
//	{
//		Response res=new Response();
//		
//		if(documentService.update(user))
//		{
//			res.setCode(ResponseCode.UPDATE_SUCCESS);
//			res.setMessage();
//		}
//		else
//		{
//			res.setCode(ResponseCode.UPDATE_FAIL);
//			res.setMessage();
//		}
//	
//		return res;
//	}
	
}

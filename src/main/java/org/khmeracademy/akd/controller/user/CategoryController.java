package org.khmeracademy.akd.controller.user;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.response.*;
import org.khmeracademy.akd.services.CategoryService;
import org.khmeracademy.akd.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public ResponseList<Category> findAll()
	{
		ArrayList<Object> cat=categoryService.findAll();
		ResponseList<Category> res=new ResponseList<Category>();
		
		if(categoryService.findAll()!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(cat);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}

	
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	public ResponseObject<Category> fineOne(@PathVariable("id") String id)
	{
		Category cat=categoryService.findOne(id);
		ResponseObject<Category> res=new ResponseObject<Category>();
		if(categoryService.findOne(id)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(cat);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id)
	{
	
		boolean status=categoryService.delete(id);
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
	
	
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public Response insert(@RequestBody Category cat)
	{
		Response res=new Response();
		if(categoryService.insert(cat)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage();
		}
		
		return res;
		
	}

	
	
	@RequestMapping(value="/category",method=RequestMethod.PUT)
	public Response update(@RequestBody Category cat)
	{
		Response res=new Response();
		
		if(categoryService.update(cat))
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
	
}
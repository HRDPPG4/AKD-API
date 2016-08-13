package org.khmeracademy.akd.controller.user;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.response.*;
import org.khmeracademy.akd.services.SavelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SavelistController {
	@Autowired
	private SavelistService savelistService;
	
	@RequestMapping(value="/savelist",method=RequestMethod.GET)
	public ResponseList<Savelist> findAll()
	{
		ArrayList<Object> list=savelistService.findAll();
		ResponseList<Savelist> res=new ResponseList<Savelist>();
		
		if(savelistService.findAll()!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(list);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}

	
	@RequestMapping(value="/savelist/{id}",method=RequestMethod.GET)
	public ResponseObject<Savelist> fineOne(@PathVariable("id") int id)
	{
		Savelist list=savelistService.findOne(id);
		ResponseObject<Savelist> res=new ResponseObject<Savelist>();
		if(savelistService.findOne(id)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(list);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/savelist/{id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("id") int id)
	{
	
		boolean status=savelistService.delete(id);
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
	
	
	
	@RequestMapping(value="/savelist",method=RequestMethod.POST)
	public Response insert(@RequestBody Savelist list)
	{
		Response res=new Response();
		if(savelistService.insert(list)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage();
		}		
		return res;		
	}	
	
	@RequestMapping(value="/savelist",method=RequestMethod.PUT)
	public Response update(@RequestBody Savelist list)
	{
		Response res=new Response();
		
		if(savelistService.update(list))
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

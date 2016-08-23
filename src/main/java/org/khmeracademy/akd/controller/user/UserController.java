package org.khmeracademy.akd.controller.user;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.Log;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.entities.User;
import org.khmeracademy.akd.response.*;
import org.khmeracademy.akd.services.LogService;
import org.khmeracademy.akd.services.SavelistService;
import org.khmeracademy.akd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseList<User> findAll()
	{
		ArrayList<Object> user=userService.findAll();
		ResponseList<User> res=new ResponseList<User>();
		
		if(userService.findAll()!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(user);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}
	
	@RequestMapping(value="/user/{userID}/logs",method=RequestMethod.GET)
	public ResponseList<Log> findAllByUser(@PathVariable("userID") int userID)
	{
		ArrayList<Log> log=logService.findAllByUser(userID);
		ResponseList<Log> res=new ResponseList<Log>();
		
		if(logService.findAllByUser(userID)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(log);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
				
		return res;
	}

	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseObject<User> fineOne(@PathVariable("id") int id)
	{
		User user=userService.findOne(id);
		ResponseObject<User> res=new ResponseObject<User>();
		if(userService.findOne(id)!=null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(user);
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("id") int id)
	{
	
		boolean status=userService.delete(id);
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
	
	
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public Response insert(@RequestBody User user)
	{
		Response res=new Response();
		if(userService.insert(user)){
			res.setCode(ResponseCode.INSERT_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.INSERT_FAIL);
			res.setMessage();
		}		
		return res;		
	}	
	
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public Response update(@RequestBody User user)
	{
		Response res=new Response();
		
		if(userService.update(user))
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

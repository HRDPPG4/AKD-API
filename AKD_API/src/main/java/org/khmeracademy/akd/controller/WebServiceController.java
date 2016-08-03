package org.khmeracademy.akd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




import org.khmeracademy.akd.entities.User;
import org.khmeracademy.akd.response.*;
import org.khmeracademy.akd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WebServiceController {
	@Autowired
	private UserService userService;
	
//	@RequestMapping(value="/user",method=RequestMethod.GET)
//	public ArrayList<User> findAll()
//	{
//		ArrayList<User> users=userService.findAll();
//		return users;
//	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAll()
	{
		ArrayList<User> users=userService.findAll();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("CODE", "200");		
		map.put("MESSAGE", "RECORD FOUND!");
		map.put("DATA", users);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK );
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User fineOne(@PathVariable("id") int id)
	{
		User user=userService.findOne(id);
		return user;
	}
	
//	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
//	public boolean delete(@PathVariable("id") int id)
//	{
//		boolean status=userService.delete(id);
//		return status;
//	}
	
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public Map<String, Object> delete(@PathVariable("id") int id)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		boolean status=userService.delete(id);
		if(status)
		{
			map.put("CODE", "200");
			map.put("MESSAGE", "REMOVE SUCCESSFUL!");
		}
		else
		{
			map.put("CODE", "404");
			map.put("MESSAGE", "REMOVE FAILED!");
		}
		return map;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public boolean insert(@RequestBody User user)
	{
		boolean status=userService.insert(user);
		return status;
	}
	
//	@RequestMapping(value="/user",method=RequestMethod.PUT)
//	public boolean update(@RequestBody User user)
//	{
//		boolean status=userService.update(user);
//		return status;
//	}
	
	
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public Response update(@RequestBody User user)
	{
		Response response=new Response();
		
		if(userService.update(user))
		{
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		}
		else
		{
			response.setCode(ResponseCode.UPDATE_FAIL);
		}
	
		return response;
	}
	
}

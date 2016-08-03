package org.khmeracademy.akd.controller;

import java.util.ArrayList;

import org.khmeracademy.akd.entities.User;
import org.khmeracademy.akd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController = @Controller + @ResponseBody
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String removeUser(@PathVariable("id") int id){
		boolean status = userService.delete(id);
		System.out.println(status);
		return "index";
	}
	
	@RequestMapping(value="/display", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<User> findAll(){
		ArrayList<User> user = userService.findAll();		
		return user;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String display(){
		return "index";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@RequestBody User user){
		boolean status = userService.insert(user);
		System.out.println(status);
		return "index";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody User user){
		boolean status = userService.update(user);
		System.out.println(status);
		return "index";
	}

	
}

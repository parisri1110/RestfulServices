package com.insanecoder.webservices.restcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insanecoder.webservices.restcourse.User;
import com.insanecoder.webservices.restcourse.service.UserDaoService;

@RestController
public class UserController {

	@Autowired
	UserDaoService userDaoService;
	
	// retrieve AllUsers
	
	@GetMapping("/users")
	public List<User> allUsers()
	{
		return userDaoService.findAll();
	}
	
	// retrieve one use
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		return userDaoService.findOne(id);
		
	}
	
	// Created
	@PostMapping("/saveusers")
	public void createUser(@RequestBody User user)
	{
	    User saveUser=userDaoService.save(user);
		
	}
	
	
	
	
}

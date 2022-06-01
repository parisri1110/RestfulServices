package com.insanecoder.webservices.restcourse.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.insanecoder.webservices.restcourse.User;
import com.insanecoder.webservices.restcourse.exception.UserNotFoundException;
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
		User user= userDaoService.findOne(id);
		if(user==null)
		{
			throw new UserNotFoundException("id " +id);
		}
		return user;
		
		
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user= userDaoService.deleteBy(id);
		if(user==null)
		{
			throw new UserNotFoundException("id " +id);
		}

		
		
		
	}
	
	// Created
	@PostMapping("/saveusers")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
	    User saveUser=userDaoService.save(user);
	    //User created
	    // /user/{id}     -> saveUser.getId()
	  
	    /* 
	     * 
	     * To return Proper status for "CREATED"
	     * 
	     *  */
	    URI location= ServletUriComponentsBuilder.fromCurrentRequest()   // this will return current request
	    .path("/{id}")
	    .buildAndExpand(saveUser.getId()).toUri();
	    return ResponseEntity.created(location).build();
		
	}
	
	
	
	
}

package com.insanecoder.webservices.restcourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//@RequestMapping(method=RequestMethod.GET,path = "/hello")
	@GetMapping("/hello")
	public String getHello()
	{
		return "Hello-World";
	}
	
	@GetMapping("/helloBean")
	public HelloWorldBean getHelloBean()
	{
		return new HelloWorldBean("Hello-World");
	}
	
	@GetMapping("/helloBean/{name}")
	public HelloWorldBean getHelloPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("HelloWorld , %s", name));
	}
	
	
}

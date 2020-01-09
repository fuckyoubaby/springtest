package com.sjx.simple.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjx.simple.entities.SimpleUser;
import com.sjx.simple.manager.UserManager;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	private UserManager userManager;
	//private static Logger logger = LogManager.getLogger(HelloWorldController.class);
	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String sayHello()
	{
		logger.info("info-test");
		logger.debug("debug-test");
		logger.error("error-test-"+userManager.getName());
		
		return "Hello World";
	}
	
	@RequestMapping(value="saveNoTran",method=RequestMethod.GET)
	public String saveNoTran(String id,String userName,String password)
	{
		SimpleUser simpleUser = new SimpleUser();
		simpleUser.setId(id);
		simpleUser.setUserName(userName);
		simpleUser.setPassword(password);
		userManager.saveUserNoTrans(simpleUser);
		return "Hello World";
	}
	
	@RequestMapping(value="saveWithTran",method=RequestMethod.GET)
	public String saveWithTran(String id,String userName,String password)
	{
		SimpleUser simpleUser = new SimpleUser();
		simpleUser.setId(id);
		simpleUser.setUserName(userName);
		simpleUser.setPassword(password);
		userManager.saveUserWithTrans(simpleUser);
		return "Hello World";
	}
}

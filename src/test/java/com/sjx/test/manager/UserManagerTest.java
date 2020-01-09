package com.sjx.test.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjx.simple.manager.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
public class UserManagerTest {


	@Autowired
	private UserManager userManager;
	@Test
	public void test() {
		
		 String name = userManager.getName();
		 System.out.println(name);
	}

}

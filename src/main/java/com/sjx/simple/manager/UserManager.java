package com.sjx.simple.manager;

import com.sjx.simple.entities.SimpleUser;

public interface UserManager {

	String getName();
	
	int saveUserNoTrans(SimpleUser user);
	int saveUserWithTrans(SimpleUser user);
}

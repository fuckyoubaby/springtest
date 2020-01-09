package com.sjx.simple.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjx.simple.dao.SimpleUserMapper;
import com.sjx.simple.entities.SimpleUser;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
	private SimpleUserMapper simpleUserMapper ;
	@Override
	public String getName() {
		SimpleUser user = simpleUserMapper.selectByPrimaryKey("1");
		System.out.println(user.getUserName());
		return "this is user name";
	}
	@Override
	public int saveUserNoTrans(SimpleUser user) {
		simpleUserMapper.insert(user);
		int i = 1/0;
		return 0;
	}
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int saveUserWithTrans(SimpleUser user) {
		simpleUserMapper.insert(user);
		int i = 1/0;
		return 0;
	}

}

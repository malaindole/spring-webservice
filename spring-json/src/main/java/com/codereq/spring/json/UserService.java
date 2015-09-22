package com.codereq.spring.json;

import java.util.Random;

import javax.transaction.Transactional;

public class UserService {

	private UserDao userDao;
	
	@Transactional
	public String createUser(UserEntity userEntity)  {
		String userId = userEntity.getName()+random();
		userEntity.setUserId(userId);
		boolean isCreated = userDao.createUser(userEntity);
		System.out.println(isCreated);
		if(isCreated) {
			return userId;
		}
		return null;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;	
	}
	
	private String random() {
		Random r = new Random();
		int num = r.nextInt(1000);
		return Integer.valueOf(num).toString();
	}

}

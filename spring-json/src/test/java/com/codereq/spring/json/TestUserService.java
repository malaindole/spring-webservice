package com.codereq.spring.json;



import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestUserService {

	@Test
	public void testCreateUser() {
		UserService userService = new UserService();
		UserEntity userEntity = new UserEntity();
		userEntity.setName("Gaurav");
		userEntity.setEmail("gs@gs.com");
		userService.setUserDao(mockUserDao(userEntity));
		String userId = userService.createUser(userEntity);
		System.out.println(userId);
		Assert.assertNotNull(userId);
	}
	
	private UserDao mockUserDao(UserEntity userEntity) {
		UserDao mockUserDao = Mockito.mock(UserDao.class);
		Mockito.when(mockUserDao.createUser(userEntity)).thenReturn(true);
		return mockUserDao;
	}

}

package com.store.service;

import com.store.entity.User;
import com.store.helper.Crow;
import com.store.service.ex.ServiceException;
import com.store.service.impl.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest
//@RunWith(SpringRunner.class)
public class UserServiceTest {
	@Autowired
	private UserServiceImpl userService;

	@Test
    public void reg() {
		System.out.println("================");
		System.out.println("測試使用者新增");

		try{
			Crow crow = new Crow();

			String nowTimeString = crow.getDateTime();

	    	String md5String = crow.getMD5(nowTimeString);
			String testString = "test_" + md5String.substring(0, 3);;
			System.out.println("testString: "+ testString);

	    	User user = new User();
	    	user.setUsername(testString);
	    	user.setPassword("123");
	    	user.setEmail(testString + "@gmail.com");
	    	user.setPhone("0987123456");


	    	this.userService.reg(user);
	    	System.out.println("使用者新增成功");

		}catch(ServiceException e){
			System.out.println(e.getClass().getSimpleName());
			System.out.println(e.getMessage());
		}
    }

	@Test
	public void login(){
		System.out.println("================");
		System.out.println("測試使用者登入");
		try {
			User user = new User();
			user.setUsername("test_8eb");
			user.setPassword("123");
			this.userService.login(user.getUsername(), user.getPassword());
			System.out.println("使用者登入成功");

		}catch(ServiceException e){
				System.out.println(e.getClass().getSimpleName());
				System.out.println(e.getMessage());
		}
	}

	@Test
    public void changePassword(){
		userService.changePassword(6, "UserServiceTest", "123", "000");
	}
}

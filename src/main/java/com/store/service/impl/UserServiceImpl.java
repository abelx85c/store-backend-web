package com.store.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import com.store.service.ex.PasswordNotMatchException;
import com.store.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.User;
import com.store.mapper.UserMapper;
import com.store.service.IUserService;
import com.store.service.ex.InsertException;
import com.store.service.ex.UsernameDuplicatedException;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) {
		System.out.println("====================");
		System.out.println("user service");
		System.out.println(user);


		String username = user.getUsername();

		User result = userMapper.findByUsername(username);

		if (result != null) {
			throw new UsernameDuplicatedException("名稱已註冊");
		}


		String oldPassword = user.getPassword();
		String salt = UUID.randomUUID().toString().toUpperCase();
//		String md5Password = getMD5Password(oldPassword, salt);
//		user.setPassword(md5Password);
		user.setPassword(oldPassword);

		user.setSalt(salt);
		user.setIsDelete(0);
		user.setCreatedUser(user.getUsername());
		user.setModifiedUser(user.getUsername());
		Date date = new Date();
		user.setCreatedTime(date);
		user.setModifiedTime(date);

		Integer rows = userMapper.insert(user);
		if (rows != 1) {
			throw new InsertException("註冊產生異常");
		}
		System.out.println("user mapper response: " + rows);
	}

	@Override
	public User login(String username, String password) {

		User result = userMapper.findByUsername(username);
		if(result == null){
			throw new UserNotFoundException("使用者不存在");
		}

		String oldPassword = result.getPassword();

		if(!password.equals(oldPassword)){
			throw new PasswordNotMatchException("使用者密碼錯誤");
		}

		User user = userMapper.findByUsername(username);
		//User user = new User();
		//user.setUsername(user.getUsername());

		return user;
	}


	private String getMD5Password(String password, String salt) {
		for (int i = 0; i < 3; i++) {
			//md5加密算法的调用(进行三次加密)
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
		}
		//返回加密后的密码
		return password;
	}

}

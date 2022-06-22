package com.store.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.User;
import com.store.mapper.UserMapper;
import com.store.service.IUserService;
import com.store.service.ex.InsertException;
import com.store.service.ex.UsernameDuplicatedException;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) {
		System.out.println("====================");
		System.out.println("user service");
		System.out.println(user);

		String username = user.getUserName();
		User result = this.userMapper.findByUsername(username);
		if(result != null) {
			throw new UsernameDuplicatedException("使用者名稱已存在");
		}


		user.setId(user.getId());
    	user.setUserAccount(user.getUserName());
    	user.setUserName(user.getUserName());
    	user.setPassword(user.getPassword());
    	user.setEmail(user.getEmail());
    	user.setPhone(user.getPhone());
    	user.setAddress(user.getAddress());
    	
		Date date = new Date();
    	String nowTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

		user.setCreateTime(nowTimeString);
		user.setUpdateTime(nowTimeString);

		System.out.println(user);
		Integer rows = this.userMapper.insert(user);
		if(rows != 1) {
			throw new InsertException("使用者新增出現異常");
		}
		System.out.println("user mapper response: " + rows);
	}

}

//package com.crow.cart.mapper;
//
//import com.store.entity.User;
//import com.store.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.springframework.util.DigestUtils;
//
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserMapperTest {
//	@Autowired
//	private UserMapper userMapper;
//
//	@Test
//    public void insert() {
//		System.out.println("================");
//		System.out.println("測試使用者新增");
//
//		Date date = new Date();
//    	String nowTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
//
//    	String md5String = DigestUtils.md5DigestAsHex(nowTimeString.getBytes());
//		String testString = "test_" + md5String.substring(0, 3);;
//		System.out.println("testString: "+ testString);
//
//    	User user = new User();
//    	user.setUserAccount(testString);
//    	user.setUserName(testString);
//    	user.setPassword("123");
//    	user.setEmail(testString + "@gmail.com");
//    	user.setPhone("0987123456");
//    	user.setAddress("火星");
//
//
//    	user.setCreateTime(nowTimeString);
//    	user.setUpdateTime(nowTimeString);
//
//    	Integer rows = userMapper.insert(user);
//    	System.out.println("新增幾筆資料: " + rows);
//    }
//}

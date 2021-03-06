package com.store.controller;

import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.store.entity.User;
import com.store.service.IUserService;
import com.store.service.ex.InsertException;
import com.store.service.ex.UsernameDuplicatedException;
import com.store.util.JsonResult;

import javax.servlet.http.HttpSession;

//@Controller
@RestController //@Controller+@ResponseBody
@RequestMapping("/users")
public class UserController extends BaseController{
    @Autowired
	private IUserService userService;

	//@ResponseBody
//    @RequestMapping("/reg")
//    public JsonResult<Void> reg(User user) {
//    	JsonResult<Void> result = new JsonResult<>();
//    	System.out.println(user);
//    	userService.reg(user);
//    	try {
//			userService.reg(user);
//			result.setState(200);
//			result.setMessage("註冊成功");
//		}catch(UsernameDuplicatedException e) {
//			result.setState(4000);
//			result.setMessage("已註冊");
//		}catch(InsertException e) {
//			result.setState(5000);
//			result.setMessage("寫入資料庫異常");
//		}
//    	return result;
//    }

	@RequestMapping("/reg")
	public JsonResult<Void> reg(User user) {
		System.out.println("====================");
		System.out.println("user controller reg");
		System.out.println(user);

		userService.reg(user);
		return new JsonResult<>(ok);
	}

	@RequestMapping("/login")
	public JsonResult<User> login(String username, String password, HttpSession session) {
		System.out.println("====================");
		System.out.println("user controller login");
		System.out.println("username from param: " + username);
		System.out.println("password from param: " + password);

		User data = userService.login(username, password);
		System.out.println("uid from login service: " + data.getUid());
		System.out.println("username from login service: " + data.getUsername());
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());

		System.out.println("uid getuidFromSession: " + getuidFromSession(session));
		System.out.println("username getUsernameFromSession: " + getUsernameFromSession(session));

		return new JsonResult<User>(ok, data);
	}

    @RequestMapping("/change_password")
	public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session){
		Integer uid = getuidFromSession(session);
		String username = getUsernameFromSession(session);
		userService.changePassword(uid, username, oldPassword, newPassword);
		return new JsonResult<>(ok);
	}
}

package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.store.entity.User;
import com.store.service.IUserService;
import com.store.service.ex.InsertException;
import com.store.service.ex.UsernameDuplicatedException;
import com.store.util.JsonResult;

//@Controller
@RestController //@Controller+@ResponseBody
@RequestMapping("/user")
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
//			result.setMessage("使用者註冊成功");
//		}catch(UsernameDuplicatedException e) {
//			result.setState(4000);
//			result.setMessage("使用者已註冊");
//		}catch(InsertException e) {
//			result.setState(5000);
//			result.setMessage("寫入資料庫異常");
//		}
//    	return result;
//    }

	@RequestMapping("/reg")
	public JsonResult<Void> reg(User user) {
		System.out.println("====================");
		System.out.println("user controller");
		System.out.println(user);
		userService.reg(user);
		return new JsonResult<>(ok);
	}
}

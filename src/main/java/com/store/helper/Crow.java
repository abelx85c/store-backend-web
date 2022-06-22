package com.store.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.util.DigestUtils;

public class Crow {

	public String getMD5(String str) {
		String md5String = DigestUtils.md5DigestAsHex(str.getBytes());
		return md5String;
	}
	
	public String getDateTime() {
		Date date = new Date();
    	String nowTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    	return nowTimeString;
	}
	
	public String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

}

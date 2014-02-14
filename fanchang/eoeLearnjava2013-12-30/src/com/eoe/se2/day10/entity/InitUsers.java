package com.eoe.se2.day10.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/*
 * 负责读取user.txt文件,封装在HashMap<User>集合中
 */
public class InitUsers {
	// 读取user.txt文件，结果保存在HashMap集合中
	public static HashMap<String, User> readUser(InputStream in) {
		HashMap<String, User> users = new HashMap<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "gbk"));
			String line;
			while ((line = reader.readLine()) != null) {
				User user = parse(line);// 一行的数据解析成User对象
				users.put(user.getName(), user);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	private static User parse(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPassword(data[2]);
		user.setPhone(data[3]);
		user.setEmaile(data[4]);
		return user;
	}
}

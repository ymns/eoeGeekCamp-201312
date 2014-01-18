package com.eoe.se1.day02;

import java.util.HashMap;

import com.eoe.se1.day01.User;

public class TestHashMap {

	/**
	 * HashMap集合,演示键值覆盖现象
	 * @param args
	 */

	public static void main(String[] args) {
		// 创建集合对象,键的类型是Ineger 值得类型是User
		HashMap<Integer, User> users = new HashMap<Integer, User>();
		// 创建一个user对象
		User user = new User(10, "张二", "4558", "144845", "sdf@qq.com");
		users.put(user.getId(), user);
		// 第二个对象
		user = new User(11, "王二", "4858", "1478345", "s4545f@qq.com");
		users.put(user.getId(), user);
		// 第三个对象
		user = new User(12, "刘飞", "4858", "1478345", "s4545f@qq.com");
		users.put(user.getId(), user);
		// 第四个对象 id值一样
		user = new User(12, "刘亦菲", "47858", "1478315", "s4545f@qq.com");
		users.put(user.getId(), user);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(10 + i));
		}
		//出现了覆盖现象
	}

}

package com.eoe.se1.day02;

import java.util.ArrayList;

import com.eoe.se1.day01.User;

public class Test_User {

	//声明一个静态的集合users
	static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) {
		initdata();
		printUser();
		//修改
		users.set(1, new User(108, "王菲", "123", "465", "456@qq.com"));
		//删除
		User user =users.remove(users.size()-1);
		System.out.println();
		printUser();
	}

	private static void printUser() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}

	}

	private static void initdata() {
		users.add(new User(101, "钱多多", "123", "159","158@qq.com"));
		users.add(new User(102, "里多多", "123", "159","158@qq.com"));
		users.add(new User(103, "王多多", "123", "159","158@qq.com"));
		users.add(new User(104, "白多多", "123", "159","158@qq.com"));
		
	}
}

package com.eoe.se1.day03;

import com.eoe.se1.day01.User;
import com.eoe.se1.day03.entity.Arraylist01;

public class Test_Arraylist01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arraylist01<User> users = new Arraylist01<>();
		users.add(new User(101, "王嘎嘎", "1234", "1154867", "df@qq.com"));
		users.add(new User(102, "阿斯蒂芬", "1223", "1154867", "df@qq.com"));
		users.add(new User(103, "王菲", "1243", "1154867", "df@qq.com"));
		users.add(new User(104, "西边的风", "1283", "1154867", "df@qq.com"));
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}

	}

}

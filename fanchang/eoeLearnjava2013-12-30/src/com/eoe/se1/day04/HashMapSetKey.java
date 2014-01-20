package com.eoe.se1.day04;

import java.util.HashMap;
import java.util.Set;

import com.eoe.se1.day01.User;

public class HashMapSetKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer, User> users =new HashMap<Integer, User>();
		User user=new User(101, "ana", "1234", "68337799", "zs@qq.com");
		users.put(user.getId(), user);
		user=new User(102, "b", "724", "68337799", "lisi@qq.com");
		users.put(user.getId(), user);
		user=new User(103, "c", "1454", "68337799", "wangwu@qq.com");
		users.put(user.getId(), user);
		Set<Integer> keys=users.keySet();//返回Map集合中的所有key-value组成的Set集合
		for(Integer key:keys){
			User u=users.get(key);
			System.out.println(u);
		}
	}

}

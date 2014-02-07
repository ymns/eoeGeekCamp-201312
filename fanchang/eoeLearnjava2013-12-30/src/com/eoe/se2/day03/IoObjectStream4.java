package com.eoe.se2.day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.eoe.se1.day01.User;

public class IoObjectStream4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User(101, "王菲", "1574896", "456", "wef@qq.com");
		ArrayList<User> users = new ArrayList<User>();
		users.add(user);
		user = new User(103, "刘亦菲", "1574896", "456", "wef@qq.com");
		users.add(user);
		user = new User(104, "张飞", "1574896", "456", "wef@qq.com");
		users.add(user);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					"D:/java_test/se2_day03/user.dat"));
			for (User user2 : users) {
				oos.writeObject(user2);
			}
			System.out.println("一组对象序列化完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

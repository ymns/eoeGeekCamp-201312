package com.eoe.se2.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.eoe.se1.day01.User;

public class IoObjectStream3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User(101, "王菲", "1574896", "456", "wef@qq.com");
		Users users = new Users();
		users.listUser.add(user);
		user = new User(103, "刘亦菲", "1574896", "456", "wef@qq.com");
		users.listUser.add(user);
		user = new User(104, "张飞", "1574896", "456", "wef@qq.com");
		users.listUser.add(user);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					"D:/java_test/se2_day03/user.dat"));
			oos.writeObject(users);
			System.out.println("对象序列化完毕");
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

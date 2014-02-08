package com.eoe.se2.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import com.eoe.se1.day01.User;

public class IoPrint01 {

	/**
	 * PrintStream类示例2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<User> users = initUsers();
		File dir = new File("d:/java_test/se2_day04");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "test02.java");
		PrintStream out = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new PrintStream(file);
			for (User user : users) {
				out.println(user);
			}
			System.out.println("数据保存完毕");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private static ArrayList<User> initUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user = new User(101, "zhagf", "158", "482", "8945123c");
		users.add(user);
		user = new User(102, "zhagf", "158", "482", "8945123c");
		users.add(user);
		user = new User(103, "zhagf", "158", "482", "8945123c");
		users.add(user);
		return users;
	}

}

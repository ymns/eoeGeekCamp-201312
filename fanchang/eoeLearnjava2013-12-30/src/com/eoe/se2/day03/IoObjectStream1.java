package com.eoe.se2.day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.eoe.se1.day01.User;

public class IoObjectStream1 {

	/**
	 * 反序列化User对象
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"d:/java_test/se2_day03/user.dat"));
			User user = (User) ois.readObject();
			System.out.println(user.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

package com.eoe.se2.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.eoe.se1.day01.User;

public class HttpTest02_Reader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User[] users;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(
					"d:/java_test/se2_day08/user.dat"));
			users = (User[]) ois.readObject();
			for (User user : users) {
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

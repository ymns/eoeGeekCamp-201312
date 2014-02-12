package com.eoe.se2.day08;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.eoe.se1.day01.User;

public class HttpTest03 {

	/**
	 * 从HFS下载user.dat，并反序列化该文件。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			URL url = new URL("http://127.0.0.1:80/user.dat");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			ois = new ObjectInputStream(in);
			// 反序列化该文件
			User[] users = (User[]) ois.readObject();
			for (User user : users) {
				System.err.println(user);
			}
		} catch (MalformedURLException e) {
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

package com.eoe.se2.day08;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import com.eoe.se1.day01.User;

public class HttpTest02 {

	/**
	 * 从HFS服务端下载user.txt文件，以对象序列化的方式保存至本地磁盘。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		BufferedReader reader = null;
		User[] users = new User[0];
		try {
			URL url = new URL("http://127.0.0.1:80/user.txt");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			oos = new ObjectOutputStream(new FileOutputStream(
					"D:/java_test/se2_day08/user.dat"));
			reader = new BufferedReader(new InputStreamReader(in, "gbk"));
			String line;
			while ((line = reader.readLine()) != null) {
				User user = parse(line);// 解析读进来的第一行字符串,存入user对象里
				users = Arrays.copyOf(users, users.length + 1);// users数组扩容
				users[users.length - 1] = user;
			}
			// 对象数组可以序列化保存
			oos.writeObject(users);
			System.out.println("下载完成!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static User parse(String line) {
		String[] data = line.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPhone(data[2]);
		user.setPwd(data[3]);
		user.setEmail(data[4]);
		return user;
	}
}

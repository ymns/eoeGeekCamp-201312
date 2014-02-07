package com.eoe.se2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.eoe.se1.day01.User;

public class IoObjectStream2 {

	/**
	 * 用对象的序列化和反序列化技术实现对象的深层复制。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		User user1 = new User(101, "王菲", "1574896", "456", "wef@qq.com");
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		// 创建字节数组输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(baos);// 创建对象输出流，并包装字节数组输出流
			oos.writeObject(user1);// 将对象user1序列化到字节数组输出流中
			System.out.println(user1);
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());// 创建字节数组输入流，数据源是字节数组输出流转换为的字节数组
			ois = new ObjectInputStream(bais);
			User user2 = (User) ois.readObject();
			System.out.println(user2);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

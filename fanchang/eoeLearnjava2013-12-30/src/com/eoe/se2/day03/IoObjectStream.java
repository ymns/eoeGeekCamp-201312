package com.eoe.se2.day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.eoe.se1.day01.User;

public class IoObjectStream {

	/**
	 * 将User类的对象序列化并保存至磁盘。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User(1001, "张飞", "123456", "4581", "854@qq.com");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					"D:/java_test/se2_day03/user.dat"));
			oos.writeObject(user);
			System.out.println("对象序列化完毕!");
			System.out.println(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

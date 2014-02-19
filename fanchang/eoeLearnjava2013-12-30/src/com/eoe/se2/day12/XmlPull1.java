package com.eoe.se2.day12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.eoe.se2.day10.entity.User;

public class XmlPull1 {

	/**
	 * @param args
	 */
	static final String DEST_PATH = "d:/java_test/se2_day12/";
	static final String FILENAME = "users3.xml";

	public static void main(String[] args) {
		ArrayList<User> users = initUsers();
		PrintWriter writer = null;

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlSerializer serializer = factory.newSerializer();
			writer = new PrintWriter(DEST_PATH + FILENAME);
			serializer.setOutput(writer);
			// 开始解析
			serializer.startDocument("utf-8", null);
			serializer.text("\n");
			//第一个元素标志
			serializer.startTag(null, "users");
			for (User user : users) {
				serializer.text("\n");
				serializer.startTag(null, "user");
				serializer.attribute(null, "id", user.getId() + "");

				serializer.text("\n\t");
				serializer.startTag(null, "name");
				serializer.text(user.getName());
				serializer.endTag(null, "name");

				serializer.text("\n\t");
				serializer.startTag(null, "password");
				serializer.text(user.getPassword());
				serializer.endTag(null, "password");

				serializer.text("\n\t");
				serializer.startTag(null, "phone");
				serializer.text(user.getPhone());
				serializer.endTag(null, "phone");

				serializer.text("\n\t");
				serializer.startTag(null, "email");
				serializer.text(user.getEmaile());
				serializer.endTag(null, "email");
				serializer.text("\n");
				serializer.endTag(null, "user");
			}
			serializer.text("\n");
			serializer.endTag(null, "users");
			serializer.endDocument();
			System.out.println(FILENAME + "生成完毕");
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private static ArrayList<User> initUsers() {
		ArrayList<User> list = new ArrayList<>();
		User user = new User(1001, "张飞", "1035", "12354897", "qwe@qq.com");
		list.add(user);
		user = new User(1002, "王飞", "1035", "12354897", "qwe@qq.com");
		list.add(user);
		user = new User(1003, "刘飞", "1035", "12354897", "qwe@qq.com");
		list.add(user);
		user = new User(1004, "陈飞", "1035", "12354897", "qwe@qq.com");
		list.add(user);
		user = new User(1005, "由一飞", "1035", "12354897", "qwe@qq.com");
		list.add(user);
		return list;
	}

}

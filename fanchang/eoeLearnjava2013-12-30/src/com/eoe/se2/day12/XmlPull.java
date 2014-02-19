package com.eoe.se2.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day10.entity.User;

public class XmlPull {

	/**
	 * @param args
	 */
	static final String SRC_PATH = "d:/java_test/se2_day12/";
	static final String FILENAME = "users1.xml";
	static ArrayList<User> users = null;
	static User user = null;

	public static void main(String[] args) {
		InputStream in = null;
		try {
			// 创建pull解析器工厂对象
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			// 创建parser解析对象
			XmlPullParser parser = factory.newPullParser();
			in = new FileInputStream(SRC_PATH + FILENAME);
			parser.setInput(in, "utf-8");
			/*
			 * XmlPullParser.START_DOCUMENT: 表示文档开始的事件 XmlPullParser.START_TAG:
			 * 标签开始事件 XmlPullParser.END_TAG: 标签结束事件 XmlPullParser.END_DOCUMENT:
			 * 文档结束事件 parser.next(); 遍历至下一个标签 parser.getName(): 取出标签名
			 */
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				switch (type) {
				case XmlPullParser.START_DOCUMENT:

					break;

				case XmlPullParser.START_TAG:
					// 取出标签名称
					String tag = parser.getName();
					if ("users".equals(tag)) {
						users = new ArrayList<User>();
					} else if ("user".equals(tag)) {
						user = new User();
						int id = Integer.parseInt(parser.getAttributeValue(0));
						// 获取属性值方案(2):parser.getAttributeValue(null, "id");
						user.setId(id);
					} else if ("name".equals(tag)) {
						user.setName(parser.nextText());// 获取标签之间的文本
					} else if ("password".equals(tag)) {
						user.setPassword(parser.nextText());
					} else if ("phone".equals(tag)) {
						user.setPhone(parser.nextText());
					} else if ("email".equals(tag)) {
						user.setEmaile(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if ("user".equals(parser.getName())) {
						users.add(user);
					} else if ("users".equals(parser.getName())) {
						for (User user2 : users) {
							System.out.println(user2);
						}
					}

					break;
				}
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

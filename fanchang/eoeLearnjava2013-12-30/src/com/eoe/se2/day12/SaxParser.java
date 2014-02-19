package com.eoe.se2.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.eoe.se2.day12.entity.User;

public class SaxParser {

	/**
	 * @param args
	 */
	static final String SRC_PATH = "d:/java_test/se2_day12/";
	static final String FILENAME = "users1.xml";

	public static void main(String[] args) {
		InputStream in = null;
		try {
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			in = new FileInputStream(SRC_PATH + FILENAME);
			MyHandler handler = new MyHandler();
			saxParser.parse(in, handler);
			ArrayList<User> users = handler.users;
			for (User user : users) {
				System.out.println(user);
			}

		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class MyHandler extends DefaultHandler {
		ArrayList<User> users;
		User user;
		// 表示<user>标签开始:true
		boolean isUserTag;
		// 存放标签名称
		String tagName;

		// 文档开始时触发
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			users = new ArrayList<User>();
			isUserTag = true;
		}

		// 标签开始时回调本方法
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			tagName = qName;
			if ("user".equals(qName)) {
				user = new User();
				user.setId(Integer.parseInt(attributes.getValue(0)));
			}
		}

		// 遇到标签内容时，回调本方法
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			// 将内容复制给字符串数组
			String data = new String(ch, start, length);
			if ("name".equals(tagName)) {
				user.setName(data);
			} else if ("password".equals(tagName)) {
				user.setPassword(data);
			} else if ("phone".equals(tagName)) {
				user.setPhone(data);
			} else if ("email".equals(tagName)) {
				user.setEmaile(data);
			}
		}

		// 标签结束
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			super.endElement(uri, localName, qName);
			if ("user".equals(qName)) {
				users.add(user);
				isUserTag = false;
			}
			// 如果不是user标签则设置tagName为null
			tagName = null;
		}

	}

}

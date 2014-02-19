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

public class SaxParser2 {

	/**
	 * @param args
	 */
	static final String SRC_PATH = "d:/java_test/se2_day12/";
	static final String FILENAMW = "users2.xml";

	public static void main(String[] args) {
		InputStream in = null;
		ArrayList<User> users;
		try {
			in = new FileInputStream(SRC_PATH + FILENAMW);
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			MyHander hander = new MyHander();
			saxParser.parse(in, hander);
			users = hander.users;
			for (User user : users) {
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class MyHander extends DefaultHandler {
		ArrayList<User> users;
		User user;

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			users = new ArrayList<User>();

		}

		// 标签开始时回调本方法
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			user = new User();
			if ("user".equals(qName)) {
				user.setId(Integer.parseInt(attributes.getValue(0)));
				user.setName(attributes.getValue(1));
				user.setPassword(attributes.getValue(2));
				user.setPhone(attributes.getValue(3));
				user.setEmaile(attributes.getValue(4));
				users.add(user);
			}
		}

	}
}

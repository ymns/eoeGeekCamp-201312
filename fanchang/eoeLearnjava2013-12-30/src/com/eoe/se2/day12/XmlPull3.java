package com.eoe.se2.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day10.entity.User;

public class XmlPull3 {

	/**
	 * @param args
	 */
	static final String SRC_PATH = "d:/java_test/se2_day12/";
	static final String FILENAME = "users2.xml";

	public static void main(String[] args) {
		FileInputStream fis = null;
		ArrayList<User> users = new ArrayList<User>();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			fis = new FileInputStream(SRC_PATH + FILENAME);
			parser.setInput(fis, "utf-8");
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				if (type == XmlPullParser.START_TAG) {
					if ("user".equals(parser.getName())) {
						User user = new User();
						for (int i = 0; i < parser.getAttributeCount(); i++) {
							String attrName = parser.getAttributeName(i);
							String attrValue = parser.getAttributeValue(i);
							if (attrName.equals("id")) {
								user.setId(Integer.parseInt(attrValue));
							} else if (attrName.equals("name")) {
								user.setName(attrValue);
							} else if (attrName.equals("password")) {
								user.setPassword(attrValue);
							} else if (attrName.equals("phone")) {
								user.setPhone(attrValue);
							} else if (attrName.equals("email")) {
								user.setEmaile(attrValue);
							}
						}
						users.add(user);
					}
				}
			}
			for (User user : users) {
				System.out.println(user);
			}

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

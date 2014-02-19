package com.eoe.se2.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day12.entity.User;

public class XmlPullClient2 {

	/**
	 * 返回所有用户信息
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day12_1/ServletPullServer";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		try {
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("连接服务端失败");
				return;
			}
			InputStream in = response.getEntity().getContent();
			XmlPullParser parser = XmlPullParserFactory.newInstance()
					.newPullParser();
			parser.setInput(in, "utf-8");
			ArrayList<User> users = new ArrayList<User>();
			User user;
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				if (type == XmlPullParser.START_TAG) {
					if ("user".equals(parser.getName())) {
						user = new User();
						user.setId(Integer.parseInt(parser.getAttributeValue(0)));
						user.setName(parser.getAttributeValue(1));
						user.setPassword(parser.getAttributeValue(2));
						user.setPhone(parser.getAttributeValue(3));
						user.setEmaile(parser.getAttributeValue(4));
						users.add(user);
					}
				}
			}
			for (User u : users) {
				System.out.println(u);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}

	}
}

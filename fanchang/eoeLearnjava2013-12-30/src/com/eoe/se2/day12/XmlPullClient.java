package com.eoe.se2.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.eoe.se2.day12.entity.User;

public class XmlPullClient {

	/**
	 * 返回名字中有"菲"的用户信息
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day12_1/ServletPullServer";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		try {
			// 创建一个集合存放提交的数据
			ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			params.add(new BasicNameValuePair("name", "菲"));
			// params.add(new BasicNameValuePair("phone", "68413377"));
			// params.add(new BasicNameValuePair("email", "wangfei@qq.com"));
			// params.add(new BasicNameValuePair("password", "1234"));

			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("连接服务端失败");
				return;
			}
			InputStream in = response.getEntity().getContent();
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(in, "utf-8");
			ArrayList<User> users = new ArrayList<User>();
			User user;
			// 解析接受到的xml成集合
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				if (type == XmlPullParser.START_TAG) {
					if ("user".equals(parser.getName())) {
						user = new User();
						user.setId(Integer.parseInt(parser.getAttributeValue(
								null, "id")));
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

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
}

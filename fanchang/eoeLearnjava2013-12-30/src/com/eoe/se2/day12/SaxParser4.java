package com.eoe.se2.day12;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.eoe.se2.day12.entity.User;

public class SaxParser4 {

	/**
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day12_1/ServletPullServer";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("name", "菲"));
		InputStream in = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("请求连接服务端失败");
			}
			in = response.getEntity().getContent();
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(in, handler);
			for (User user : handler.users) {
				System.out.println(user);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class MyHandler extends DefaultHandler {
		ArrayList<User> users;
		User user;

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			users = new ArrayList<User>();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if ("user".equals(qName)) {
				user = new User();
				user.setId(Integer.parseInt(attributes.getValue("id")));
				user.setName(attributes.getValue(1));
				user.setPassword(attributes.getValue(2));
				user.setPhone(attributes.getValue(3));
				user.setEmaile(attributes.getValue(4));
				users.add(user);
			}
		}
	}
}

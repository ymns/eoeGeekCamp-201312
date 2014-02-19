package com.eoe.se2.day12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.eoe.se2.day12.entity.User;

public class SaxParser5 {

	/**
	 * 从服务端下载user.xml文档SAX解析
	 * 
	 * @param args
	 */
	static final String BASE_URL = "http://localhost:8080/se2_day12_1/ServletPullServer";
	static final String DEST_PATH = "d:/java_test/se2_day12/";
	static final String FILENAME = "user.xml";

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(BASE_URL);
		ObjectOutputStream oos = null;
		InputStream in = null;
		try {
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("请求连接服务端失败");
			}
			in = response.getEntity().getContent();
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			Myhandler handler = new Myhandler();
			saxParser.parse(in, handler);
			oos = new ObjectOutputStream(new FileOutputStream(DEST_PATH
					+ FILENAME));
			oos.writeObject(handler.users);
			for (User u : handler.users) {
				System.out.println(u);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static class Myhandler extends DefaultHandler {
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

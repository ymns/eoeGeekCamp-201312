package com.study.se2_12SAX_xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Sax_xml2 {

	public static void main(String[] args) {
		try {
			InputStream in=getInputStream();
			
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parser=factory.newSAXParser();
			MyHandler handler=new MyHandler();
			parser.parse(in, handler);
			for(Person person:handler.persons){
				System.out.println(person);
			}
						
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class MyHandler extends DefaultHandler {
		ArrayList<Person> persons;
		Person person;
		String currenTag;
		String currenValus;
		boolean isPersonTag = false;

		@Override
		public void startDocument() throws SAXException {
			persons = new ArrayList<>();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if ("person".equals(qName)) {
				person = new Person();
				isPersonTag = true;
			}
			currenTag = qName;
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String data = new String(ch, start, length);
			if ("id".equals(currenTag)) {
				person.setId(Integer.parseInt(data));
			} else if ("name".equals(currenTag)) {
				person.setName(data.trim());
			} else if ("age".equals(currenTag)) {
				person.setAge(Integer.parseInt(data));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if ("person".equals(qName)) {
				persons.add(person);
				isPersonTag = false;
			}
			currenTag = null;
		}
	}

	private static InputStream getInputStream() {
		InputStream in = null;
		try {
			URL url = new URL("http://10.0.0.60/person.xml");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(3000);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			int code = connection.getResponseCode();
			if (code == 200) {

				in = connection.getInputStream();
			}
			return in;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("下载文件失败");
			
		}
		return null;
	}

}

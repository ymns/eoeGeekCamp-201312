package com.eoe.se2_day02SAX_xml;
import java.io.File;
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

import com.eoe.test.Person;

public class Sax_xml {

	public static void main(String[] args) {
		InputStream in = null;
		try {
			File file = new File("D:/se2/day04/person.xml");
			in = new FileInputStream(file);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(in, handler);
			for (Person per : handler.persons) {
				System.out.println(per);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static class MyHandler extends DefaultHandler {
		ArrayList<Person> persons;
		Person person;
		boolean isPersontag = false;
		String tagName;

		@Override
		public void startDocument() throws SAXException {

			persons = new ArrayList<>();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if ("person".equals(qName)) {
				person = new Person();
				person.setId(Integer.parseInt(attributes.getValue("id")));
				isPersontag = true;
			}
			tagName = qName;
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String data = new String(ch, start, length);
			if ("id".equals(tagName)) {
				person.setId(Integer.parseInt(data));
			} else if ("name".equals(tagName)) {
				person.setName(data);
			} else if ("age".equals(tagName)) {
				person.setAge(Integer.parseInt(data));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			if ("person".equals(qName)) {
				persons.add(person);
				isPersontag = false;
			}
			tagName = null;
		}
	}

}

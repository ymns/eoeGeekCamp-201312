package com.eoe.se2.day12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser3 {

	/**
	 * 解析一个android的xml文件
	 * 
	 * @param args
	 */
	static final String SRC_PATH = "d:/java_test/se2_day12/";
	static final String FILENAMW = "listview.xml";
	static LinearLayout layout;
	static ListView listView;

	public static void main(String[] args) {
		InputStream in = null;
		try {
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			in = new FileInputStream(SRC_PATH + FILENAMW);
			saxParser.parse(in, new MyHander());
			System.out.println(layout);
			System.out.println(listView);
			System.out.println("<LinearLayout/>");
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class MyHander extends DefaultHandler {
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if ("LinearLayout".equals(qName)) {
				layout = new LinearLayout();
				layout.name = qName;
				layout.xmlns = attributes.getValue(0);
				layout.layout_width = attributes.getValue(1);
				layout.layout_height = attributes.getValue(2);
				layout.orientation = attributes.getValue(3);
			} else if ("ListView".equals(qName)) {
				listView = new ListView();
				listView.name = qName;
				listView.id = attributes.getValue(0);
				listView.layout_width = attributes.getValue(1);
				listView.layout_height = attributes.getValue(2);

			}
		}
	}

	static class LinearLayout {
		String name;
		String xmlns;
		String orientation;
		String layout_width;
		String layout_height;

		public LinearLayout() {
		}

		public LinearLayout(String name, String xmlns, String orientation,
				String layout_width, String layout_height) {
			super();
			this.name = name;
			this.xmlns = xmlns;
			this.orientation = orientation;
			this.layout_width = layout_width;
			this.layout_height = layout_height;
		}

		@Override
		public String toString() {
			String space = "\t";
			return "<" + name + "\n" + space + "xmlns:android=\"" + xmlns
					+ "\"\n" + space + "android:layout_width=\"" + layout_width
					+ "\"\n" + space + "android:layout_height=\""
					+ layout_height + "\"\n" + space + "android:orientation=\""
					+ orientation + "\">\n" ;
		}

	}

	static class ListView {
		String name;
		String id;
		String layout_width;
		String layout_height;

		public ListView() {
		}

		public ListView(String name, String id, String layout_width,
				String layout_height) {
			super();
			this.name = name;
			this.id = id;
			this.layout_width = layout_width;
			this.layout_height = layout_height;
		}

		@Override
		public String toString() {
			String space = "\t";
			return space + "<" + name + "\n" + space + space + "android=id\""
					+ id + "\"\n" + space + space + "android:layout_width=\""
					+ layout_width + "\"\n" + space + space
					+ "android:layout_height=\"" + layout_height + "\"/>\n";
		}

	}

}

package com.eoe.se2.day13.activity2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ParserXml {

	static int lastId = 0x700020;

	/**
	 * parserXml:用于解析指定id的布局文件
	 * 
	 * @param args
	 */
	static HashMap<String, Bundle> parserXml(String filename) {
		HashMap<String, Bundle> bundles = new HashMap<String, ParserXml.Bundle>();
		// 获得filename代表的布局文件的输入流
		InputStream in = ParserXml.class.getResourceAsStream(filename);
		try {
			XmlPullParser parser = XmlPullParserFactory.newInstance()
					.newPullParser();
			parser.setInput(in, "utf-8");
			/*
			 * 以下循环将filename代表的xml文件中所有 有id值的控件的id、控件代表的类的包名
			 * 封装在bundle对象中，保存在bundles集合中
			 */
			for (int type = XmlPullParser.START_DOCUMENT; type != XmlPullParser.END_DOCUMENT; type = parser
					.next()) {
				if (type == XmlPullParser.START_TAG) {
					String strId = parser.getAttributeValue(null, "android:id");
					if (strId == null) {
						continue;
					}
					// 获取@+id/tvName中/后面的id值
					strId = strId.substring(strId.indexOf("/") + 1);
					// 获取标签名称,即类名
					String tag = parser.getName();
					Bundle bundle = new Bundle(
							"com.eoe.se2.day13.view2." + tag, strId);
					lastId++;
					// 将lastId转换为16进制数
					String key = "0x" + Integer.toHexString(lastId);
					// 将封装了当前控件的bundle对象添加至集合中
					bundles.put(key, bundle);
				}
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bundles;

	}

	/*
	 * Bundle封装了xml中有id值的控件的名称(类的完整路径) 和该控件的id值
	 */
	static class Bundle {
		// 类的完整路径：包名
		private String pkgname;
		// 标签的id值
		private String id;

		public Bundle() {
		}

		public Bundle(String pkgname, String id) {
			super();
			this.pkgname = pkgname;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Bundle [pkgname=" + pkgname + ", id=" + id + "]";
		}

	}

	public static void main(String[] args) {
		HashMap<String, Bundle> bundles = parserXml("activity_main.xml");
		for (Map.Entry<String, Bundle> entry : bundles.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

package com.eoe.se2.day13.activity;

import java.util.HashMap;

import com.eoe.se2.day13.view.View;

public class Activity {

	/**
	 * @param args
	 */
	static HashMap<String, String> bundles;

	static <T extends View> T findViewById(int id) {
		initBundles();// 初始化集合
		String key = "0x" + Integer.toHexString(id);
		// 通过键获取值，值就是指定类的完整包名
		String value = bundles.get(key);

		try {
			Class<?> clazz = Class.forName(value);
			T view = (T) clazz.newInstance();
			view.setBackgorund("黑色");
			view.setId("view");
			view.setLayout_height("200dp");
			view.setLayout_height("138");
			return view;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;

	}

	// 初始化bundles集合，该集合中存放了三个类的包名，键是索引
	private static void initBundles() {
		bundles = new HashMap<>();
		bundles.put("0x700020", "com.eoe.se2.day13.view.TextView");
		bundles.put("0x700021", "com.eoe.se2.day13.view.EditText");
		bundles.put("0x700022", "com.eoe.se2.day13.view.Button");
	}

}

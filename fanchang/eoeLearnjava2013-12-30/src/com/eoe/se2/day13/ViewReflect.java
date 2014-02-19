package com.eoe.se2.day13;

import com.eoe.se2.day13.view.View;

public class ViewReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 第一种方式获取或加载Class对象：View.class;
		View v = new View();// 第二种方式：加载或获取View.class至内存
		try {
			Class clazz = Class.forName("com.eoe.se2.day13.view.View");
			System.out.println(clazz == v.getClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

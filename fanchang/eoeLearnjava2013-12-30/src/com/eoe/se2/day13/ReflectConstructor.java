package com.eoe.se2.day13;

import java.lang.reflect.Constructor;

public class ReflectConstructor {

	/**
	 * 通过反射获取View类的所有构造器.
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.View";

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName(PACKAGE);
			Constructor[] c = clazz.getConstructors();
			for (Constructor constructor : c) {
				System.out.println(constructor);
			}
			System.out.println();
			c = clazz.getDeclaredConstructors();
			for (Constructor constructor : c) {
				System.out.println(constructor);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

package com.eoe.se2.day13;

public class ReflectView {

	/**
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.Button";

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(PACKAGE);
			do {
				System.out.println(clazz);
				clazz = clazz.getSuperclass();
			} while (clazz != Object.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

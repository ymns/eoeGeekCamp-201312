package com.eoe.se2.day13;

import java.lang.reflect.Field;

public class ReflectGen {

	/**
	 * 获取R.java的内部类
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.gen.R";

	public static void main(String[] args) {
		try {
			// 加载R.class->Class对象
			Class<?> clazz = Class.forName(PACKAGE);
			// 获取R类中所有内部类
			Class<?>[] classes = clazz.getClasses();
			for (Class<?> c : classes) {
				// System.out.println(c);
				if (c.getName().indexOf("id") >= 0) {// 如果要检索的字符串值没有出现，则该方法返回
														// -1
					Field[] fields = c.getFields();
					for (Field field : fields) {
						int value = Integer
								.parseInt(field.get(null).toString());
						System.out.println(field.getName() + " :0x"
								+ Integer.toHexString(value));
					}
				}

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

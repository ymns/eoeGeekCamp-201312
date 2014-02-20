package com.eoe.se2.day13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.eoe.se2.day13.view.View;

public class ReflectField1 {

	/**
	 * 通过反射获取View类的所有方法。
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.View";

	public static void main(String[] args) {
		try {
			// 加载View.class->Class对象
			Class clazz = Class.forName(PACKAGE);
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				System.out.println(method);
			}
			Method getCount = clazz.getDeclaredMethod("getCount");
			getCount.setAccessible(true);
			int count = (int) getCount.invoke(null, null);
			System.out.println(count);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}

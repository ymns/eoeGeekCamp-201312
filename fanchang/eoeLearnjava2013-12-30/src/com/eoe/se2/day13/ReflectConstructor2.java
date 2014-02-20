package com.eoe.se2.day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.eoe.se2.day13.view.View;

public class ReflectConstructor2 {

	/**
	 * 通过反射调用构造器按以下三种方式创建对象， 1-带所有参数的构造器创建对象； 2-无参构造器创建对象； 3-带一个参数的构造器创建对象。
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.View";

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName(PACKAGE);
			// 无参数构造
			Constructor c = clazz.getConstructor();
			View v = (View) c.newInstance();
			v.setId("@+id/view");
			v.setLayout_width("200dp");
			v.setLayout_height("300dp");
			v.setBackgorund("黑色");
			System.out.println(v);

			// 创建带一个参数的构造器
			c = clazz.getDeclaredConstructor(String.class);
			c.setAccessible(true);
			v = (View) c.newInstance("白色");
			v.setBackgorund("白色");
			System.out.println(v);

			// 创建带四个参数的构造器
			c = clazz.getConstructor(String.class, String.class, String.class,
					String.class);
			v = (View) c.newInstance("@+id/view", "300dp", "200dp", "蓝色");
			System.out.println(v);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
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

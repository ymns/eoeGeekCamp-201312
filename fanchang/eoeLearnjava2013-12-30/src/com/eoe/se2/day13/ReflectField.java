package com.eoe.se2.day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.eoe.se2.day13.view.View;

public class ReflectField {

	/**
	 * 通过反射获取View类的所有成员变量
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.View";

	public static void main(String[] args) {
		try {
			// 加载View.class->Class对象
			Class clazz = Class.forName(PACKAGE);
			View v = null;
			// 获取带四个参数的构造器
			Constructor c = clazz.getConstructor(String.class, String.class,
					String.class, String.class);
			v = (View) c.newInstance("@+id/view", "300", "200", "白色");
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.println(field.getName() + ":" + field.get(v));
			}
			fields[1].setAccessible(true);
			fields[1].set(v, "30");
			System.out.println(fields[1].getName() + ":" + fields[1].get(v));
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

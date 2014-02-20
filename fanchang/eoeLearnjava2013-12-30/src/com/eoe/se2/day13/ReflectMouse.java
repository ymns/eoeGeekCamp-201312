package com.eoe.se2.day13;

public class ReflectMouse {

	/**
	 * 通过反射获取Mouse类的接口和父类。
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.entity.Mouse";

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(PACKAGE);
			Class<?>[] interfaces = clazz.getInterfaces();
			// 获取所有接口
			for (Class<?> inter : interfaces) {
				System.out.println(inter);
			}
			// 获取直接父类
			Class<?> superclass = clazz.getSuperclass();
			System.out.println(superclass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

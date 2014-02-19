package com.eoe.se2.day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Reflect4 {

	/**
	 * 打印View类的所有构造器的访问权限 和方法签名。
	 * 
	 * @param args
	 */
	static final String PACKAGE = "com.eoe.se2.day13.view.View";

	public static void main(String[] args) {
		// 加载View类
		try {
			Class clazz = Class.forName(PACKAGE);
			Constructor[] constructor = clazz.getDeclaredConstructors();
			for (Constructor c : constructor) {
				// 获取访问修饰符
				int m = c.getModifiers();
				String permits = Modifier.toString(m);
				String cName = c.getName().substring(
						c.getName().lastIndexOf(".") + 1);
				// System.out.println(permits + " " + cName);
				// 获取参数数组
				Class[] params = c.getParameterTypes();
				// for (Class class1 : params) {
				//
				// System.out.println(class1);
				// }
				// 修饰所有参数
				StringBuilder sb = new StringBuilder("(");
				for (int i = 0; i < params.length; i++) {
					String p = params[i].getName().substring(
							params[i].getName().lastIndexOf(".") + 1);
					sb.append(p).append(" arg" + i + ",");
				}
				if (params.length >= 1) {
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(")");
				System.out.println(permits + " " + cName + sb.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

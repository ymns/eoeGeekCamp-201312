package com.eoe.basic.day02;

public class Test05 {

	/**
	 * 变量的作用域示例(3)
	 */
	public static void main(String[] args) {
		String name="张三";
		System.out.println(name);
		{
			//String name="张三";
			System.out.println(name);
		}
	}
}

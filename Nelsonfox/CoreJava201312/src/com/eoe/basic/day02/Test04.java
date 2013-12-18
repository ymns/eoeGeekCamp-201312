package com.eoe.basic.day02;

public class Test04 {
	/**
	 * 变量的作用域示例(2)
	 */
	public static void main(String[] args) {
		{ //语句块(1)
			String name="张三";
			System.out.println(name);
		}//语句块(1)结束
		String name="张三";
		System.out.println(name);
	}
}

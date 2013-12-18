package com.eoe.basic.day02;

public class Test03 {

	/**
	 * 变量的作用域示例:同一作用域内变量不能重复定义。
	 */
	public static void main(String[] args) {
		{
			String name="张三";
			//String name="张三";
		}
	}
}

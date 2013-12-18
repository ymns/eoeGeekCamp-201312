package com.eoe.pre.textday02;
/**
 * 变量的作用域示例(2)
 */
public class Test04 {
	public static void main(String[] args)
	{
		{
		String name="张飞";
		System.out.println(name);
	}
		String name="张飞";
		System.out.println(name);
}
}
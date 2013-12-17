package com.eoe.java.school;

public class Test05 {

	/**
	 * 变量的作用域示例(3)
	 */
	public static void main(String[] args) {
		String name="王多英";
		System.out.println(name);
		{
			System.out.println(name);
		}

	}

}

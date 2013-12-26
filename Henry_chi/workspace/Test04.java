package com.eoe.java.school;

public class Test04 {

	/**
	 * 变量的作用域示例(2)
	 */
	public static void main(String[] args) {
		{//语句块一
			String name="王多英";
			System.out.println(name);
		}//语句块一结束
		    String name="王多英";
		    System.out.println(name);

	}

}

package com.eoe.basic.day02;

public class Test19 {
	/**
	 * 示例：Java对char类型的数据在底层是按int类型来处理的。
	 */
	public static void main(String[] args) {
		char ca='a';
		int i=ca+1;//ca按int型处理是97+1=98
		char cb=(char) (ca+1);//转换成小写字母b
		System.out.println(cb+":"+i);
	}
}

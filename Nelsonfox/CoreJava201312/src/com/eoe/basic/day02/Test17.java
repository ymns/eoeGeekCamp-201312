package com.eoe.basic.day02;

public class Test17 {

	/**
	 * 课堂练习:说出变量b的值
	 *  int i= Byte.MAX_VALUE + 1;
		byte b= (byte) i;
	 */
	public static void main(String[] args) {
		// int类型转换为byte类型
		int i= Byte.MAX_VALUE + 1;
		byte b= (byte) i;
		System.out.println("int:" + i);
		System.out.println("byte:" + b);
	}
}

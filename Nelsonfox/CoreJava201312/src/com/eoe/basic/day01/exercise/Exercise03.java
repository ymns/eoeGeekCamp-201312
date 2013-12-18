package com.eoe.basic.day01.exercise;

public class Exercise03 {
	/**
	 * 4、编写程序，文件名：J07.java，计算两个字节，即16位的二进制数最大值：
     *	 (1111111111111111)2=()10 
	 */
	public static void main(String[] args) {
		System.out.print("(1111111111111111)2=");
		System.out.println(Math.pow(2, 16)-1);
	}
}

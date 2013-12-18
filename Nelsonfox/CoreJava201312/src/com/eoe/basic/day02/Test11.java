package com.eoe.basic.day02;

public class Test11 {
	/**
	 * int类型的数据自动转换为long类型
	 * 超过32位的高位自动补0或1
	 */
	public static void main(String[] args) {
		int i=-2;
		long l=i;
		System.out.println("int类型的-2:"+Integer.toBinaryString(i));
		System.out.println("long类型的-2:"+Long.toBinaryString(l));
	}
}

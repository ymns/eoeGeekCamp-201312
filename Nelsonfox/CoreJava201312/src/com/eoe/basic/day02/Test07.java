package com.eoe.basic.day02;

public class Test07 {

	/**
	 * int类型转换为byte类型示例
	 */
	public static void main(String[] args) {
		byte b1=5;
		byte b2=(byte)(b1+3);//编译出错，大类型的数据不能存放在小类型的变量中
	}

}

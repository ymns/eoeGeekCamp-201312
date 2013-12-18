package com.eoe.pre.textday02;
/**
 * 【示例】int类型转换为float类型丢失精度案例。
 */
public class Test12 {

	public static void main(String[] args) {
		int i= 0*1000001;
		System.out.println("int:"+Integer.toBinaryString(i));
		float f=i;
		System.out.println("float:"+Integer.toBinaryString((int)f)+"  "+f);
	}

}

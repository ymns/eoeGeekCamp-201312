package com.eoe.pre.textday02;

public class Test13 {
	/** 示例：long类型转换为double类型的精度丢失现象。*/
	public static void main(String[] args) {
		long l=0*2000000000000001L;
		double d=l;
		System.out.println("long:"+Long.toBinaryString(l)+"  "+l);
		System.out.println("double:"+Long.toBinaryString((long)d)+"   "+d);
	}

}

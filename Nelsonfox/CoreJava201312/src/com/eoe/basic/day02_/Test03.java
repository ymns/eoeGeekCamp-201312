package com.eoe.basic.day02_;

public class Test03 {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//System.out.println(Math.pow(2, 32));
		//如果保存一个文件的长度，以字节为单位，应该用哪种数据类型
		//short,int,long,byte
		long fileSize;
		//2的31次方=2G
		double i=Double.parseDouble("18.5");
		System.out.println(i+10);
		System.out.println(Integer.toBinaryString(127));
		System.out.println("(15)10=("+Integer.toHexString(15)+")16");
	}
}

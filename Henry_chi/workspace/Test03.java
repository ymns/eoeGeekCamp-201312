package com.eoe.day01;

public class Test03 {
	/**
	 * Test03:演示常用的数学运算，包括：
	 * 加、减、乘、除
	 * m的n次幂
	 * 平方根
	 * 绝对值
	 * 四舍五入
	 * 取整
	 */
	public static void main(String[] args){
		System.out.println("53+50="+(53+50));
		System.out.println("53-50="+(53-50));
		System.out.println("53*50="+(53*50));
		System.out.println("53/50="+(53/50));
		System.out.println("5的8次方="+Math.pow(5, 8));
		System.out.println("4的平方根="+Math.sqrt(4));
		System.out.println("|-15|="+Math.abs(-15));
		System.out.println("13/5="+Math.round(13.0/5));
		System.out.println("7/3="+Math.floor(7/3));
	}
}

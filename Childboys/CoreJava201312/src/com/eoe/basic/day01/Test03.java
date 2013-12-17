package com.eoe.basic.day01;

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
	public static void main(String[] args) {
		System.out.print("嗨，大家好，俺叫张三，现在达内学习IT软件开发");
		System.out.println("以下用Java进数学运算");
		System.out.println("100+15="+(100+15));
		System.out.println("100-15="+(100-15));
		System.out.println("100*15="+100*15);
		System.out.println("100/15="+100/15);
		System.out.println("100%15="+100%15);
		System.out.println("2的4次方="+Math.pow(2, 4));
		System.out.println("120的平方根="+Math.sqrt(120));
		System.out.println("|-15|="+Math.abs(-15));
		System.out.println("5/3＝"+Math.round(5.0/3));
		System.out.println("5/3="+Math.floor(5.0/3));
	}
}

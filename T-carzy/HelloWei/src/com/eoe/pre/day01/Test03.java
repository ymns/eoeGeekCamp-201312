package com.eoe.pre.day01;

public class Test03 {
	public static void main(String[] args)
	// 20的平方根+10的平方根，再除以(20的平方根-10的平方根)
	{
		double a = Math.sqrt(20);
		double b = Math.sqrt(10);
		double c = (a + b) / (a - b);
		System.out.println("20的平方根+10的平方根，再除以(20的平方根-10的平方根)是：" + c);
	}
}

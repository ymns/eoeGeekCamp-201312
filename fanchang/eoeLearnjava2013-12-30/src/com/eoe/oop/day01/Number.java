package com.eoe.oop.day01;

public class Number {

	/**
	 * @param args
	 */
	int a;
	int b;
//无参的
	public Number() {
		super();
	}
//有2个参数的构造方法
	public Number(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	private static void swap(Number number) {
		int c=number.a;
		number.a=number.b;
		number.b=c;
		
	}
	public static void main(String[] args) {
		//测试对象作为方法的参数实现两个变量的互换
		Number num = new Number(10,5);
		swap(num);
		System.out.println(num.a+" "+num.b);
	}


}

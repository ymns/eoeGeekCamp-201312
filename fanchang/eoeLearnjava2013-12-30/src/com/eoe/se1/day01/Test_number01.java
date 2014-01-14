package com.eoe.se1.day01;

public class Test_number01 {

	/**
	 * 静态内部类
	 * 实现交换值
	 * @param args
	 */
	static class Number{
		int a;
		int b;
		public Number() {
			// TODO Auto-generated constructor stub
		}
		public Number(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "Number [a=" + a + ", b=" + b + "]";
		}
	}
	static void swap(Number num){
		int c=num.a;
		num.a=num.b;
		num.b=c;
	}

	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number num1=new Number(10,5);
		System.out.println(num1);
		swap(num1);
		System.out.println(num1);

	}

}

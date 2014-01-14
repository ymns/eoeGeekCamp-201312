package com.eoe.se1.day01;

public class Test_number03 {

	/**
	 * 局部内部类
	 * @param args
	 */
	public static void main(String[] args) {

		//创建局部内部类
		class Number03{
			int a;
			int b;

			public Number03(int a, int b) {
				super();
				this.a = a;
				this.b = b;
			}
			@Override
			public String toString() {
				return "Number03 [a=" + a + ", b=" + b + "]";
			}
			//交换方法
			void swap(Number03 num){
				int c=num.a;
				num.a=num.b;
				num.b=c;
			}
		}
		Number03 num3=new Number03(10,5);
		System.out.println(num3);
		num3.swap(num3);
		System.out.println(num3);

	}

}

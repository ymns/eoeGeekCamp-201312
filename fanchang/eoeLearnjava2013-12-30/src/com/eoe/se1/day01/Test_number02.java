package com.eoe.se1.day01;

public class Test_number02 {

	/**
	 * 成员内部类
	 * @param args
	 */
	
	class Number2{   //定义一个成员内部类
		int a;
		int b;
		public Number2() {
			// TODO Auto-generated constructor stub
		}
		public Number2(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "Number1 [a=" + a + ", b=" + b + "]";
		}	
	}
	//写一个交换的方法,非静态的
	void swap(Number2 num2){
		int c=num2.a;
		num2.a=num2.b;
		num2.b=c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test_number02 t1=new Test_number02();
		Number2 number=t1.new Number2(10, 5);
		System.out.println(number);
		t1.swap(number);
		System.out.println(number);

	}

}

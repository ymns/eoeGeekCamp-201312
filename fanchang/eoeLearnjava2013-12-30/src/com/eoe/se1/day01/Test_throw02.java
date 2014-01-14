package com.eoe.se1.day01;

import java.util.Scanner;

public class Test_throw02 {

	/**
	 * 在四则运算中:
	 * 自定义异常类
	 * 1.乘法运算后越界
	 * 2.除法被除数不能为0
	 * @param args
	 *
	 */
	
	public static void main(String[] args)  {
		@SuppressWarnings("resource")
		Scanner scanner =new Scanner(System.in);
		System.out.println("a [+,-,*,/] b=");
		int a=scanner.nextInt();
		char c=scanner.next().charAt(0);
		int b=scanner.nextInt();
		try {
			compter4(a,c,b);
		} catch (OutOfIntMaxValueException e) {
			System.out.println(e.toString());
		} catch (DivideByZero e) {
			System.out.println(e.toString());
		}

	}

	private static void compter4(int a,char c,int b) 
			throws OutOfIntMaxValueException, DivideByZero {
		switch (c) {
		case '+':
			System.out.println(a+b);
			break;
		case '-':
			System.out.println(a-b);
			break;
		case '*':
			System.out.println(a*b);
			if (1.0*a*b>Integer.MAX_VALUE) {
				throw new OutOfIntMaxValueException("超出int值得最大值");//抛出异常
			}
			break;
		case '/':
			if (b==0) {
				throw new DivideByZero("除零错误!");//抛出异常
			}
			System.out.println(a/b);
			break;
		default:
			System.out.println("输入运算符号错误!");
			break;
		}
		
	}
	//自定义超出最大值异常
	static class OutOfIntMaxValueException extends Exception{
		public OutOfIntMaxValueException(String message) {
			super(message);
		}
	}
	//自定义除0错误异常
	static class DivideByZero extends Exception{
		public DivideByZero(String message) {
			super(message);
		}
	}

}

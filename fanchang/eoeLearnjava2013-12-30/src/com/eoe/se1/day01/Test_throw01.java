package com.eoe.se1.day01;

public class Test_throw01 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		method1();//返回到这儿
		System.out.println("main");
	}

	private static void method1() {
		try {           
			method2();             //返回到这里
		} catch (ArrayIndexOutOfBoundsException e) {   //被捕获
			System.out.println(e.toString());
		}
		System.out.println("method1");
		
	}//抛给main

	private static void method2() {
		int[] a=new int[2];
		System.out.println(a[2]);    //出现异常,抛给mathod1
		System.out.println("俺不会被执行到!");  //不会执行到这里
		
	}
	

}

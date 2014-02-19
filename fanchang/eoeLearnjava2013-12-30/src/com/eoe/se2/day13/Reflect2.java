package com.eoe.se2.day13;

public class Reflect2 {

	/**
	 * 带任意参数个数方法的案例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		print(1, "hello...");
		print(2, "hell~", "world~");
		print(3, "hello", "world", "android");
	}

	static void print(int count, String... args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}
}

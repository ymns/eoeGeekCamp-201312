package com.eoe.se1.day03;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_Genericity {

	/**
	 * 用泛型方法实现对任意类型的数组和集合的数据复制
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1-字符串数组赋值");
		System.out.println("2-Integr数组赋值");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:
			String[] name = { "张飞", "李明", "刘亦菲", "王菲" };
			ArrayList<String> list = new ArrayList<String>();
			copy(name, list);
			System.out.println(list);
			break;
		case 2:
			Integer[] a = { 100, 200, 300, 400 };
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			copy(a, list2);
			System.out.println(list2);
			break;
		}
	}
	//泛型方法,适用任意类型
	private static <T> void copy(T[] a, ArrayList<T> list2) {
		for (T t : a) {
			list2.add(t);
		}
	}

}

package com.eoe.se1.day03;

import java.util.ArrayList;

public class Genericity01 {

	/**
	 * 设定泛型参数的上限
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Double> list1 = new ArrayList<Double>();
		list1.add(45.3);
		list1.add(12.0);
		list1.add(45.8);
		printlist(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		list2.add(120);
		list2.add(458);
		printlist(list2);
	}

	// 设定必须是Number和其子类
	private static void printlist(ArrayList<? extends Number> list) {
		for (int i = 0; i < list.size(); i++) {
			System.err.println(list.get(i));
		}

	}

}

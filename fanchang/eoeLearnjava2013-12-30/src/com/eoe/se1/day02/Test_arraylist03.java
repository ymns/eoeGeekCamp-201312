package com.eoe.se1.day02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_arraylist03 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入删除的整数");
		int i = scanner.nextInt();
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove((Integer)i);
		System.out.println(list);

	}

}

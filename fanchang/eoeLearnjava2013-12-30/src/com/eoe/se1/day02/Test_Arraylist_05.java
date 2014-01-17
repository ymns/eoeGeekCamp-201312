package com.eoe.se1.day02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_Arraylist_05 {

	/**
	 * 集合的地址复制,值复制,equal()与==的差别
	 * 
	 * @param args
	 */
	static ArrayList<Integer_> list;
	static ArrayList<Integer_> list2;
	static final int ADDRESS__COPY = 1;
	static final int VALUE_COPY = 2;

	public static void main(String[] args) {
		initlist();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-复制集合地址");
		System.out.println("2-复制集合元素");
		int select = scanner.nextInt();
		// 打印所有元素
		System.out.println(list);
		switch (select) {
		case ADDRESS__COPY:
			list2 = list;
			System.out.println("集合list与list2的内容相同:" + list.equals(list2));
			System.out.println("集合list与list2是同一个集合对象:" + (list == list2));
			break;
		case VALUE_COPY:
			list2 = new ArrayList<Integer_>();
			for (int i = 0; i < list.size(); i++) {
				list2.add(list.get(i));
			}
			System.out.println("集合list与list2的内容相同:" + list.equals(list2));
			System.out.println("集合list与list2是同一个集合对象:" + (list == list2));
			list.set(0, new Integer_(150));
			System.out.println("list="+list);
			System.out.println("list2="+list2);
			Integer_ i=list.get(1);
			i.value=250;
			list.set(1, i);
			System.out.println("list="+list);
			System.out.println("list2="+list2);
			break;
		}
	}

	private static void initlist() {
		// 创建集合对象并由集合变量list引用
		list = new ArrayList<Integer_>();
		Integer_ i = new Integer_(100);
		list.add(i);
		list.add(new Integer_(200));
		list.add(new Integer_(300));

	}

}

class Integer_ {
	int value;

	public Integer_(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return " " + this.value;
	}

}

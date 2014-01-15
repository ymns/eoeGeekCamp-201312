package com.eoe.se1.day02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_arraylist02 {

	/**
	 * 集合Arraylist 
	 * 1.创建集合 
	 * 2.添加集合元素 
	 * 3.两种打印集合元素的方法
	 * 4.删除集合元素 
	 * 5.判断集合元素是否集中
	 * 6.清除集合中所有元素
	 * 
	 * @param args
	 */
	// 定义常量
	static final int TOSTRING_ACTION = 1;
	static final int FOR_ACTION = 2;
	static final int UPDATA_ACTION = 3;
	static final int REMOVE_ACTION = 4;
	static final int CONATINS_ACTION = 5;
	static final int CLEAR_ACTION = 6;

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		ArrayList<String> names =initArraylist();
		System.out.println("1-利用toString()打印集合所有元素");
		System.out.println("2-利用循环打印集合所有元素");
		System.out.println("3-修改集合元素值");
		System.out.println("4-删除集合元素值");
		System.out.println("5-判断指定元素是否包含在集合中");
		System.out.println("6-清除集合所有元素");
		System.out.println(names);
		System.out.println("选择1~6");
		int select=scanner.nextInt();
		switch (select) {
		case TOSTRING_ACTION:
			System.out.println(names);
			break;
		case FOR_ACTION:
			for (int i = 0; i < names.size(); i++) {
				System.out.println(names.get(i));
			}
			break;
		case UPDATA_ACTION:
			names.set(1, "汪小菲");
			System.out.println(names);
			break;
		case REMOVE_ACTION:
			names.remove(2);
			System.out.println(names);
			break;
		case CONATINS_ACTION:
			System.out.println(names);
			String name=names.remove(2);
			name="咖啡";
			System.out.println(name+names.contains(name));
			System.out.println(names);
			break;
		case CLEAR_ACTION:
			names.clear();
			if (names.isEmpty()) {
				System.out.println("集合是空的!");
			}
			System.out.println(names);
			break;
		}

	}
	
	private static ArrayList<String> initArraylist() {
		// 创建一个集合对象names
		ArrayList<String> names = new ArrayList<String>();
		// 向集合添加四个字符串数据
		names.add("王飞");//
		names.add("刘亦菲");
		names.add("张飞");
		names.add("咖啡");
		return names;
	}

}

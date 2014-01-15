package com.eoe.se1.day02;

import java.util.ArrayList;

public class Test_arraylist01 {

	/**
	 * 集合Arraylist的使用练习
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("王飞");
		names.add("刘亦菲");
		names.add("张飞");
		names.add("咖啡");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println(names);

		// 在本题的基础上对以上集合进行删除某个元素、修改某个元素的操作
		names.remove(0); // 移除元素下表0
		names.remove(2); // 移除元素下标2
		System.out.println(names);
		names.set(1, "李伟"); // 修改下标1
		System.out.println(names);
		names.add("张大千");
		System.out.println(names);
		names.clear();
		System.out.println(names);

	}

}

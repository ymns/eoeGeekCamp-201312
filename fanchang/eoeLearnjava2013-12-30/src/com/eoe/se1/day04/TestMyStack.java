package com.eoe.se1.day04;

import com.eoe.se1.day04.entity.MyStack;

public class TestMyStack {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack<String> names = new MyStack<>();
		names.push("王菲");
		names.push("刘亦菲");
		names.push("梁文峰");
		names.push("王飞");
		System.out.println(names);
		for (String name:names) {
			System.out.println(name);
		}
		names.pop();
		System.out.println("*************");
		for (String name:names) {
			System.out.println(name);
		}
		
	}

}

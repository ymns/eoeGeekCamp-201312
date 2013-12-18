package com.eoe.basic.day02;

/**
 * 本例演示 
 * 1、数据类型的多样，造成变量的类型的多样
 * 2、变量中的数据可以改变。
 */
public class Test02 {
	public static void main(String[] args) {
		String name = "鲍小猩";
		
		int age = 23;
		double height = 1.2;
		boolean isMarry = false;// 未婚，true:已婚
		System.out.println("嗨，大家好，俺叫" + name + ",今年" + age + "岁，身高：" + height
				+ "米\t已婚："+isMarry);
		//以下演示变量存放了新的数据，原来的数据丢失了。
		name = "曹大帅";
		//sex = '男';
		age = 26;
		height = 2.1;
		isMarry = true;// 未婚，true:已婚
		System.out.println("嗨，大家好，俺叫" + name + ",今年" + age + "岁，身高：" + height
				+ "米\t已婚："+isMarry);
	}
}

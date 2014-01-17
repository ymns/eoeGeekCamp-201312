package com.eoe.se1.day03;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.eoe.se1.day03.entity.Arraylist01;

public class Test_Genericity01 {

	/**
	 * 通配符?的使用
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> name =new ArrayList<String>();
		name.add("朱元璋");
		name.add("白起");
		name.add("韩信");
		printList(name);
		ArrayList<Integer> i=new ArrayList<Integer>();
		i.add(12);
		i.add(34);
		i.add(46);
		printList(i);
	}
	//打印任意类型的集合
	private static void printList(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	

}

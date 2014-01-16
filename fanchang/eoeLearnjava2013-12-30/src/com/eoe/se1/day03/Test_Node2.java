package com.eoe.se1.day03;

import javax.xml.soap.Node;

import com.eoe.se1.day03.entity.Node2;

public class Test_Node2 {

	/**
	 * 泛型中的两个类型
	 * 两个数据的链表
	 * @param args
	 */
	public static void main(String[] args) {
		Node2<Character, Integer> link = new Node2<Character, Integer>();
		;
		Node2<Character, Integer> root = link;
		link.value1 = 'a';
		link.value2 = 333;
		link.next = new Node2<Character, Integer>();
		link = link.next;
		link.value1 = 'b';
		link.value2 = 222;
		link.next = new Node2<Character, Integer>();
		link = link.next;
		link.value1 = 'c';
		link.value2 = 111;
		link = root;
		while (link!=null) {
			System.out.println(link.value1+"  "+link.value2);
			link=link.next;
		}

	}

}

package com.eoe.se1.day03;

import com.eoe.se1.day03.entity.NodeChar;

public class Test_NodeChar {

	/**
	 * 链表测试
	 * @param args
	 */
	public static void main(String[] args) {
		NodeChar link=new NodeChar();
		NodeChar root=link;     //链表头,第一个节点
		link.value='a';
		//在堆中创建第二个节点对象，地址保存在link.next
		link.next=new NodeChar();  
		link=link.next;   //link指向第二个节点
		link.value='b';    //第二个节点的值
		link.next=new NodeChar();    //创建第三个对象,地址存入link.next
		link=link.next;          //link指向第三个节点
		link.value='c';
		link=root;       //link存入链表头的地址
		while(link!=null) {
			System.out.println(link.value);
			link=link.next;
		}

	}

}

package com.eoe.pre.textday02;
/**
 * 编写程序，实现两个字符类型变量值互换
 */
public class Exercise04 {
	public static void main(String[] args){
		char c1='A';
		char c2='B';
		System.out.print("c1="+c1+"\tc2="+c2);
		c1=(char) (c2+c1);
		c2=(char) (c1-c2);
		c1=(char) (c1-c2);
		System.out.println("\tc1="+c1+"\tc2="+c2);
	}
}

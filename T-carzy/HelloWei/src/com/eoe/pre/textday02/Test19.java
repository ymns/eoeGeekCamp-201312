package com.eoe.pre.textday02;
/**
 * 示例：Java对char类型的数据在底层是按int类型来处理的。
 */
public class Test19 {
	public static void main(String[] args){
		char ca='b';
		int i=ca+1;
		char c=(char) (ca+1);
		System.out.println(c+":"+i);
	}

}

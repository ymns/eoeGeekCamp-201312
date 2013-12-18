package com.eoe.basic.day02;

public class Test09 {
	/**
	 * 打印出unicode码从0～127的所有字符
	 */
	public static void main(String[] args) {
		for(int i=0;i<128;i++){
			System.out.println((char)i+":"+i);
		}
//		System.out.println((char)0+":"+0);//打印unicode码为0的字符
//		System.out.println((char)1+":"+1);//打印unicode码为1的字符
//		//...
//		System.out.println((char)127+":"+127);//打印unicode码为127的字符
	}

}

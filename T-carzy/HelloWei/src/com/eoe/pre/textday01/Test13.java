package com.eoe.pre.textday01;
//计算四个字节，即32位的二进制数最大值
public class Test13 {
	public static void main(String[] args){
		long a=(long) (Math.pow(2, 32));
		System.out.println("最大值是："+(a-1));
		
	}

}

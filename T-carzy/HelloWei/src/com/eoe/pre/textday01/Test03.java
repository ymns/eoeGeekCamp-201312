package com.eoe.pre.textday01;
//关于二进制一堆1的简便方法
public class Test03 {
	public static void main(String[] args){
		System.out.print("(11111111)2=");
		System.out.println(Math.pow(2, 6)+
		Math.pow(2, 5)+Math.pow(2, 4)+
		Math.pow(2, 3)+Math.pow(2, 2)+
		Math.pow(2, 1)+Math.pow(2, 0));
		System.out.println(Math.pow(2, 8)-1);
	}

}

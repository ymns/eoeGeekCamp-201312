package com.eoe.pre.textday01;
//编程找三个数3，4，5的中间数。要求不能使用if、switch等判断语句。
public class Test12 {
	public static void main(String[] args){
		int a=3;
		int b=4;
		int c=5;
		System.out.println("3，4，5的中间数是"+
		Math.min(b, Math.max(a, c)));
	}
}

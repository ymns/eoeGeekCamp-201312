package com.eoe.basic.day02_;
//不借助第三个变量，两个变量值互换.
public class Test19 {
	public static void main(String[] args) {
		int a=5;
		int b=50;
		System.out.println("a="+a+"  b="+b);
		a+=b;//a=a+b; a=5+50  b=50
		b=a-b;//a=55   b=5
		a-=b;
		System.out.println("a="+a+"  b="+b);
		//ctrl+d:快速删除一行代码
		System.out.println(~(4)+1);
		
//		a=528;
//		//a%10=8
//		//a/10%10=2
//		a/100
	}
}

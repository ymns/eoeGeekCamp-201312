package com.eoe.pre.textday02;
/**
 * int类型转换为byte类型示例
 */
public class Test07 {
	public static void main(String[] args){
		//byte b1=5;
		//byte b2=b1+3;//编译出错，大类型的数据不能存放在小类型的变量中
		byte b=5;
		byte w=(byte) (b+1);
	}
}

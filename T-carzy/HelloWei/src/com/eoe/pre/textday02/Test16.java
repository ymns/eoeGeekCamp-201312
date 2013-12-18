package com.eoe.pre.textday02;
/**
 * 大范围类型的数据若超过了小范围类型的位数，则超过的位数会自动舍弃。
 */
public class Test16 {
	public static void main(String[] args){
		int i=277;
		byte b=(byte) i;
		System.out.println("int:"+Integer.toBinaryString(i)+"   "+i);
		System.out.println("bute:"+Integer.toBinaryString(b)+"   "+b);
	}

}

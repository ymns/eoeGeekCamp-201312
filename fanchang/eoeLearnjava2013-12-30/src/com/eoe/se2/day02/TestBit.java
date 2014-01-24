package com.eoe.se2.day02;

import java.util.Scanner;

public class TestBit {

	/**
	 * 通过位运算计算文件大小，按指定格式返回任意单位的字 节数
	 * 
	 * @param args
	 */
	static final byte BYTE=1;//0001
	static final byte KB=2;  //0010
	static final byte MB=4;  //0100
	static final byte GB=8;  //1000
	public static void main(String[] args) {
		System.out.println("输入文件的大小(单位：字节)");
		long size=new Scanner(System.in).nextLong();
		String text=fileSize(size, BYTE|KB|MB|GB);
		System.out.println(text);
	}
	//fileSize:根据输入的字节数，返回文件大小
	static String fileSize(long size,int mode){
		if(mode==(BYTE|KB|MB|GB)){
			if(size<1024){
				return size+"byte";
			}else if(size<1024*1024){
				return size/1024.0+"kb";
			}else if(size<1024*1024*1024){
				return size/1024.0/1024+"mb";
			}else{
				return size/1024.0/1024/1024+"gb";
			}
		}
		
//		if(mode==BYTE){
//			return size+"byte";
//		}
//		if(mode==KB){
//			return size/1024+"kb";
//		}
//		if(mode==MB){
//			return size/1024/1024+"mb";
//		}
//		if(mode==GB){
//			return size/1024/1024/1024+"gb";
//		}
		return null;
	}
}

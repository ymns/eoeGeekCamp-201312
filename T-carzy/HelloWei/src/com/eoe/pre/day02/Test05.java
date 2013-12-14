package com.eoe.pre.day02;

public class Test05 {
	public static void main(String[] args){
		String s="987654321";
		int len=s.length();
		for(int i=0;i<=s.length();i++)
		{
			System.out.println(s.substring(0,len-i));
		}
		s="  123456789   ";
		System.out.println(s.trim());
	}
}

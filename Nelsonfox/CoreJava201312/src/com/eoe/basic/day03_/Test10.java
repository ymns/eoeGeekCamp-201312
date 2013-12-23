package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test10 {

	public Test10() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner input=new Scanner(System.in);
    System.out.println("a [+,_,*,/,%] b");
    int a=input.nextInt();
    char c=input.next().charAt(0);
    int b=input.nextInt();
    System.out.println(""+a+c+b+"=");
    switch(c){
    case '+':
    	System.out.println(a+b);
    	break;
    case '-':
    	System.out.println(a-b);
    	break;
    case '*':
    	System.out.println(a*b);
    	break;
    case '/':
    	System.out.println(a/b);
    	break;
    	default:
    		System.out.println("不能进行四则运算");
    }
    
	}

}

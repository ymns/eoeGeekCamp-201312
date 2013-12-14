package com.eoe.pre.day01;
import java.util.Scanner;
public class Test07{
	public static void main (String[] args)
    {
		Scanner scanner=new Scanner(System.in);
	    System.out.println("name:");
		String name=scanner.next();
	    System.out.println("sex:");
		char sex=scanner.next().charAt(0);
            System.out.println("age:");
		int age=scanner.nextInt();
	    System.out.println("height:");
		double height=scanner.nextDouble();
	    System.out.println("大家好，我叫"+name+"我今年"+age+"岁，我是个"+sex+"的，我身高"+height+"米");
    }
		   }
package com.eoe.pre.day02;
import java.util.Scanner;
public class Test06 {
	public static void main(String[] args)
	{
	Scanner scanner=new Scanner(System.in);
	System.out.println("1-Test01");
	System.out.println("2-Test02");
	System.out.println("3-Test03");
	System.out.println("4-Test04");
	System.out.printlb("5-Test05");
	int select=scanner.nextInt();
	switch(select){
	case 1:
		Test01.main(null);
	}
	}
}

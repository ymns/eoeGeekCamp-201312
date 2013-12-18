package Test;

import java.util.Scanner;

public class Test18 {

	public Test18() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("a=");
int a=scanner.nextInt();
System.out.println("b=");
int b=scanner.nextInt();
int c=a;
a=b;
b=c;
System.out.println("a="+a+"\tb="+b);
	}

}

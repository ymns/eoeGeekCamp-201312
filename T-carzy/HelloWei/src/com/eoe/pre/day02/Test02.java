package com.eoe.pre.day02;
import java.util.Scanner;
import java.util.Arrays;
public class Test02{
	public static void main(String[] args)
    {
	    System.out.println(Arrays.toString(args));
		String[] grades={"不及格","不及格","及格","良","优"};
	    	Scanner scanner=new Scanner(System.in);
	    System.out.println("输入五分制的分数");
		int score=scanner.nextInt();
	    System.out.println(grades[score]);

    }
		   }
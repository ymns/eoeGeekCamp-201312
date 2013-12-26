package com.eoe.pre.day01;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Test06{
	public static void main(String[] args)
    {
		Scanner scanner=new Scanner(System.in);
	    System.out.println("请输入分数");
		int score=scanner.nextInt();
		if(score>=60){
	    System.out.println("及格");
	}else{
            System.out.println("不及格");           }
    }
                   }

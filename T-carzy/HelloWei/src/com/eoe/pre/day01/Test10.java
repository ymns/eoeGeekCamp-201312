package com.eoe.pre.day01;
import java.util.Scanner;
public class Test10{
	public static void main(String[] args)
    {
		Scanner scanner=new Scanner(System.in);
	    System.out.println("java=");
		int java=scanner.nextInt();
	    System.out.println("android=");
		int android=scanner.nextInt();
	    System.out.println("sql=");
		int sql=scanner.nextInt();
	    System.out.println("project=");
		int project=scanner.nextInt();
		if(java>=90 && android>=90 && sql>=90 && project>=90)
	   {System.out.println("恭喜，您被本公司录用，月薪8K");
	  }else if(java>=90 && android>=90 && sql>=90 || project>=90 )
	   {System.out.println("恭喜，您被本公司录用，月薪5K");
	  }else if(java>=90 || android>=90 || sql>=90 || project>=90)
	   {System.out.println("恭喜，您本本公司录用，月薪3K");
	  }else{System.out.println("等通知吧");}
    }
     		   }

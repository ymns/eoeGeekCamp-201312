package day05_ex;

import java.util.Scanner;

public class Exercise04 {

	/**
	 * @param args
	 * 不用判断语句，输入百分制的分数，根据以下标准评定分数等级：
	   90～100:优秀
	   89-80:良好
	   79-70:中等
	   69-60:及格
	   0－59:不及格
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int score;
		AAA :while(true){
		do{
		System.out.println("输入一个100以内的分数：");
		 score=sc.nextInt();
		}while(score<0 ||score>100);
	    int grade=score/10;
	    switch(grade){
	    case 10:
	    case 9:
	    	System.out.println("优秀");
	    	continue AAA;
	    case 8:
	    	System.out.println("良好");
	    	continue AAA;
	    case 7:
	    	System.out.println("中等");
	    	continue AAA;
	    case 6:
	    	System.out.println("及格");
	    	continue AAA;
	    case 5:
	    case 4:
	    case 3:
	    case 2:
	    case 1:
	    case 0:
	    	System.out.println("不及格");
	    	continue AAA;
	   default:
		  // System.out.println("输入的不是百分制，请重新输入：");
		   break;	
	    }	
	}
}
}
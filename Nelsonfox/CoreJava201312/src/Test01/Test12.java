package Test01;

import java.util.Scanner;

public class Test12 {

	public Test12() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    int score;
    do{
    	System.out.println("输入5分制的分数：");
    	score=scanner.nextInt();
    }while(score<0 || score>5);
    System.out.println("输入OK");
	}

}

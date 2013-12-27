package Day05;

import java.util.Scanner;

public class test13 {

	/**
	 * @param args  不用判断语句练习月份对应的天数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n;
		do{
			System.out.println("请输入一个月份：");
			n=scanner.nextInt();
		}while(n<1 || n>12);
		 String[] days={"31天","28天","31天","30天",
				 "31天","30天","31天","31天",
				 "30天","31天","30天","31天",};
		 System.out.println(days[n-1]);
	}
}

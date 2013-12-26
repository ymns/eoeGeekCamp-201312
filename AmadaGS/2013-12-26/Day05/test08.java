package Day05;

import java.util.Scanner;

public class test08 {

	/**
	 * @param args不用判断语句给5分制评定等级
	 */
	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
		 //System.out.println("请输入五分制：");
		 int score;
		 do{
			 System.out.println("请输入五分制：");
			  score=scanner.nextInt();
			  
		 }while(score<0||score>5);
			 
		 String[] grades={ 
				"不及格","不及格","不及格",
				 "及格","良好","优秀"};
		 System.out.println(grades[score]);
		 
	}
}

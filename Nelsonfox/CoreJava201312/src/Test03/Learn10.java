package Test03;

import java.util.Scanner;

public class Learn10 {

	public Learn10() {
		// TODO Auto-generated constructor stub
	}

	/**输出5分支的分数第三种方法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);

int score;
for(score=-1;score<0 || score>5;){
	score=scanner.nextInt();
	System.out.println("输入5分制的分数");
}
System.out.println("是5分制的分数");
	}

}

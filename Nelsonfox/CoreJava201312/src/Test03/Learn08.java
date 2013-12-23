package Test03;

import java.util.Scanner;

public class Learn08 {

	public Learn08() {
		// TODO Auto-generated constructor stub
	}

	/**键盘输入数据，当输入的数小于0或大于5时，继续循环，
	 * @param args如果在0到5之间，跳出循环，输出“是5分制
	 * 的分数”
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("输入5分制的分数");
int score;
do{
	score=scanner.nextInt();
}while(score<0 || score>5);
System.out.println("是5分制的分数");
	}

}

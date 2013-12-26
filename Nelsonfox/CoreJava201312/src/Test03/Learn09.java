package Test03;

import java.util.Scanner;

public class Learn09 {

	public Learn09() {
		// TODO Auto-generated constructor stub
	}

	/**输出5分制的分数方法2
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("輸入5分制的分數");
int score=-1;
while(score<0 || score>5){
	score=scanner.nextInt();
}
System.out.println("是5分制的分數");
	}

}

package Exercise;

import java.util.Scanner;

public class Exercise05 {

	public Exercise05() {
		// TODO Auto-generated constructor stub
	}

	/**键盘输入一个int类型的负数，求出该数的补码。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 System.out.println("請輸入：");
     Scanner scanner=new Scanner(System.in);
     int m=scanner.nextInt();
     System.out.println(~m+1);//补码取反加一
	}

}

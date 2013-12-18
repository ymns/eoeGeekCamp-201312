package Exercise;

import java.util.Scanner;

public class Exercise01 {

	private static int n;

	public Exercise01() {
		// TODO Auto-generated constructor stub
	}

	/**编写程序，计算2^n，要求：
	//a<<n;
	(1)n由键盘输入。
	(2)不能使用Math.pow()
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
        Scanner cin = new Scanner(System.in);  
        int n = cin.nextInt();  
        System.out.println(1<<n);//求2的n次方 

   
	}

}

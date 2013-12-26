package Exercise;

import java.util.Scanner;

public class Exercise07 {

	public Exercise07() {
		// TODO Auto-generated constructor stub
	}

	/**键盘输入一个整数，要求只输入四位数。然后将该数反向打印。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("請輸入一個四位數：");
    Scanner scanner=new Scanner(System.in);
    int m=scanner.nextInt();
    int n=m/1000;//最高位取出，//取整
    int e=m%1000/100;//次高位
    int s=m%100/10;//第三位
    int z=m%10;//个位
    System.out.println("結果為："+z+s+e+n);
	}

}

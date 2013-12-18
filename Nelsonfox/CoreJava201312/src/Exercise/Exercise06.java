package Exercise;

import java.util.Scanner;

public class Exercise06 {

	public Exercise06() {
		// TODO Auto-generated constructor stub
	}

	/**键盘输入两个int类型的数，打印这两个数是否相等。
	 * @param args
	 */
	public static void main(String[] args) {
	 // TODO Auto-generated method stub
     Scanner scanner=new Scanner(System.in);
     int m=scanner.nextInt();
     System.out.println(m);
     int n=scanner.nextInt();
     System.out.println(n);
     Boolean s=(m==n);//bool型判断m是否等于n，等于，输出true
     System.out.println("結果為："+s);
     }

}

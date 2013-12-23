package Test03;

import java.util.Scanner;

public class Learn14 {

	public Learn14() {
		// TODO Auto-generated constructor stub
	}

	/**计算，输出的是从0到n相加的结果
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();
int t=0;
for(int i=1;i<=n;i++){
	t+=i;
}
System.out.println(t);
	}

}

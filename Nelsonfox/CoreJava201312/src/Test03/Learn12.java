package Test03;

import java.util.Scanner;

public class Learn12 {

	public Learn12() {
		// TODO Auto-generated constructor stub
	}

	/**输出M的N次方，M；N都由键盘输入
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("m n=");
int m=scanner.nextInt();
int n=scanner.nextInt();
double result=1;
for(int i=1;i<=n;i++){
	result*=m;
}
System.out.println(result);
	}

}

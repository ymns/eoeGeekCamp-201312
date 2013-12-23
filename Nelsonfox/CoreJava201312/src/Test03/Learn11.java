package Test03;

import java.util.Scanner;

public class Learn11 {

	public Learn11() {
		// TODO Auto-generated constructor stub
	}

	/**输出的是2的N次方，N由键盘输入
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();
int result=1;
for(int i=1;i<=n;i++){
	result*=2;
}
System.out.println(result);
	}

}

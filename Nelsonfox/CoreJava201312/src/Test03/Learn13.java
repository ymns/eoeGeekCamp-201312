package Test03;

import java.util.Scanner;

public class Learn13 {

	public Learn13() {
		// TODO Auto-generated constructor stub
	}

	/**输出的是N的阶层
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();
double result=1;
for(int i=1;i<=n;i++){
	result*=i;
}
System.out.println(result);
	}

}

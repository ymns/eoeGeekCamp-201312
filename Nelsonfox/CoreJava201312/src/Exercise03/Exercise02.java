package Exercise03;

import java.util.Scanner;

public class Exercise02 {

	public Exercise02() {
		// TODO Auto-generated constructor stub
	}

	/** 编写程序， 计算：1+1/2+1/3+..+1/n，要求：
      键盘输入n的值，保留小数点后2位。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();
double result=0;
for(double i=1;i<=n;i++){
	result+=(1.0/i);
	 
}
System.out.println(result);
	}

}

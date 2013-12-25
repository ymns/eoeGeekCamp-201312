package Test04;

import java.util.Scanner;

public class Test06 {

	public Test06() {
		// TODO Auto-generated constructor stub
	}

	/**判定质数，只能被1和自己整除的数，键盘输入数据
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();//键盘输入一个数据
boolean isPrime=true;//将质数定义为布尔型
int k=(int)Math.sqrt(n);//简化式子，定义K为N的平方根
for(int i=2;i<=k&&isPrime;i++){//
	isPrime=n%i!=0;//输入数字N除以I的每一个取值，除到N的平方根为止
}
System.out.println(n+"是质数："+isPrime);
	}

}

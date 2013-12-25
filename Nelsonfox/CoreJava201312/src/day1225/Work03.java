package day1225;

import java.util.Scanner;

public class Work03 {

	public Work03() {
		// TODO Auto-generated constructor stub
	}

	/**计算：1/1-1/2+1/3-1/4+...+1/(n-1)-1/n      
	键盘输入n的值，保留小数点后2位。 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("n=");
int n=scanner.nextInt();
double result=0;
for(int i=1;i<=n;i+=2){
	result+=1.0/i-1.0/(i+1);//循环体，这里i加1
}
System.out.println("1/1-1/2+1/3-1/4+...1/n="+Math.round(result*100.0)/100.0);
	}

}

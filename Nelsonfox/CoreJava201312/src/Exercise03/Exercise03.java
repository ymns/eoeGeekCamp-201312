package Exercise03;

import java.util.Scanner;

public class Exercise03 {

	public Exercise03() {
		// TODO Auto-generated constructor stub
	}

	/**输出1-1/2+1/3-1/4........1/n;
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("请输入一个整数");
Scanner  scanner=new Scanner(System.in);
int n=scanner.nextInt();
double sum=1;
for(double i=2;i<n;i++){
	if(i%2==0){
		sum=sum-(1/i);
	}else{
		sum=sum+(1/i);
	}
}
System.out.println("sum="+Math.round(sum));
	}

}

package Day05;

import java.util.Scanner;

public class test11 {

	/**
	 * @param args  判断是否是水仙花
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n ;
		do{ 
			System.out.println("请输入一个baiwei数：");
			 n=scanner.nextInt();
		}while(n>1000 ||n<100);
		
		int i=n%10;
		int j=(n/10)%10;
		int k=n/100;
		int a=i*i*i+j*j*j+k*k*k;
		if(n==a){
			System.out.println(n+"是水仙花");
		}else{
			System.out.println("不是  ");
		}

	}

}

package Day05;

import java.util.Scanner;

public class test01 {

	/**
	 * @param args练习使用多重循环
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入m=");
		  int  m=scanner.nextInt();
		  System.out.println("请输入n=");
		  int n=scanner.nextInt();
/*		  for(int j=0;j<n;j++){
			  System.out.println("*");
		  }
		  System.out.println();
		 
		  for(int j=0;j<n;j++){
			  System.out.println("*");
		  }
		  System.out.println();*/
		  
		  /*int i=0;
		  for(int j=0;j<n;j++){
			  System.out.print("*");
		  }
		  System.out.println();
		  
		  
		  i++;
		  for(int j=0;j<n;j++){
			  System.out.print("*");
		  }
		  System.out.println();
		  
		  
		  i++;
		  for(int j=0;j<n;j++){
			  System.out.print("*");
		  }
		  System.out.println();*/
		  
		  for(int i=0;i<m;i++){    //打印m行
			  for(int j=0;j<n;j++){    //打印n列
				  System.out.print("*");  
			  }
			  System.out.println(); 
			  //外循环的循环体，每打印一行执行换行
		  }
		  
		  
		  
		  
		  
	}

}

package Exercise;

import java.util.Scanner;

public class Exercise08 {

	public Exercise08() {
		// TODO Auto-generated constructor stub
	}
    static int a;
    static int b;
    //static int c;
    //static int d;
   // static int e;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     compute();
	}
	
    static void compute(){
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("请输入运算符号：");
    	int f=scanner.nextInt();
    	int a=scanner.nextInt();
    	int b=scanner.nextInt();
    	switch(f){
    	case '+':
    		System.out.println(a+b);
    		break;
    	case '-':
    		System.out.println(a-b);
    		break;
    	case '*':
    		System.out.println(a*b);
    		break;
    	case '/':
    		System.out.println(a/b);
    		break;
    }
    }
}

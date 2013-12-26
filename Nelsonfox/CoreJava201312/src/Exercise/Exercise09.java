package Exercise;

import java.util.Scanner;

public class Exercise09 {

	public Exercise09() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入页数");
		int number=scanner.nextInt();
		int page=number/10;
		if(number%10==0){
			System.out.println(page);
		}else{
			System.out.println(number/10+1);
		}
	}
	}



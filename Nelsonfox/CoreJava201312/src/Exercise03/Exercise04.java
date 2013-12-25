package Exercise03;

import java.util.Scanner;

public class Exercise04 {

	public Exercise04() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Scanner scanner=new Scanner(System.in);
//System.out.println("n=");
//nt n=scanner.nextInt();
		
for(int n=100;n<=200 && n>=100;n++){
	IsPrime();
}
	}
	static void IsPrime(){
		int n=100;
	boolean isPrime=true;
	int k=(int)Math.sqrt(n);
	for(int i=2;i<=k&&isPrime;i++){
		isPrime=n%i!=0;
	}
	System.out.println(n);
	}
}

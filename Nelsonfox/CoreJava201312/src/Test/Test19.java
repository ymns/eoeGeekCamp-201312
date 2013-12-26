package Test;

public class Test19 {

	public Test19() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     double sqrt20=Math.sqrt(20);
     double sqrt10=Math.sqrt(10);
     double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
     result=Math.round(result*100)/100.0;
     System.out.println("sqrt(20)+sqrt(10)/sqrt(20)-sqrt(10)="+result);
	}

}

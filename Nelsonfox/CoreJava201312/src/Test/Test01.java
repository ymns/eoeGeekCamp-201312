package Test;

public class Test01 {

	public Test01() {
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
    System.out.println(result);
    System.out.println(Math.round(result)*10/10d);
	}

}

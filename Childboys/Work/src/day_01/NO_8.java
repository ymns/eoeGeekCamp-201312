package day_01;

public class NO_8 {

	/**
	 * 编程找三个数3，4，5的中间数。要求不能使用if、switch等判断语句。
	 */
	public static void main(String[] args) {
		int a=3;
		int b=4;
		int c=5;
        int min=a<b?a:b;
        int man=b<c?b:c;
        int m=min>man?min:man;
        System.out.println("中间数是"+m);
	}

}

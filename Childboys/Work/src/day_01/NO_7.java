package day_01;

public class NO_7 {

	/**
	 * 编写Exercise06类，计算3712秒是几小数、几分、几秒。
	 */
	public static void main(String[] args) {
		int a;//时
		int b;//分
		int c;//秒 
		int n=3712;
		a=(n/60)/60;
		b=(n-(a*60*60))/60;
		c=n-((a*60)*60)-(b*60);
		System.out.println("3712秒"+a+"小时"+b+"分"+c+"秒");

	}

}

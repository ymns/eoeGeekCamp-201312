package Test04;

public class Learn01 {

	public Learn01() {
		// TODO Auto-generated constructor stub
	}

	/**计算(∑10+∑5)*(∑8+∑4)/(pow(2,8)-5!)+4!-pow(3,4)的值
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = (add(10) + add(5)) * (add(8) + add(4))
				/ (myPow(2, 8) - fact(5)) + fact(4) - myPow(3, 4);
		System.err.println("(∑10+∑5)*(∑8+∑4)/(pow(2,8)-5!)+4!-pow(3,4)=");
		System.err.println(result);
	}
//计算m的n次方
	static double myPow(double m, int n) {
		double result = 1;
		for (int i = 1; i <= n; i++) {
			result *= m;
		}
		return result;
	}
//计算n的阶层
	static double fact(int n) {
		double result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
//计算1到n相加
	static double add(int n) {
		double result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
}

package Exercise;

public class Exercise03 {

	public Exercise03() {
		// TODO Auto-generated constructor stub
	}

	/**编写程序，不用第三个变量，用减法实现两个变量值互换。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int m=50;
      int n=5;
      m=m-n;//m=45,n=5
      n=m+n;//m=45,n=50
      m=n-m;//m=5,n=50，调换成功
      System.out.println("m="+m+"   n="+n);
	}

}

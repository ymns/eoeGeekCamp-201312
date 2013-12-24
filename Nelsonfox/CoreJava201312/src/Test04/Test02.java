package Test04;

public class Test02 {

	public Test02() {
		// TODO Auto-generated constructor stub
	}

	/**无限循环中输出0到5件的数字,解法（1）
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=0;
while(true){
	System.out.println(i%6);
     i++;
     //i=i<5?i+1:0;三目运算当i小于5,大于0时，i+1；当i不在0到5的范围是i=0
}
	}

}

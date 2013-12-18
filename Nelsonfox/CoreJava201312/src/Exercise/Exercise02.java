package Exercise;

import java.util.Scanner;

public class Exercise02 {

	public Exercise02() {
		// TODO Auto-generated constructor stub
	}

	/**编写计算华氏转换为摄氏温度的程序，公式： 摄氏温度值=（华氏温度值-32）×5÷9
   要求：
   	 (1)华氏设施温度由键盘输入。
     (2)保留小数点后1位。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    double WenDu=scanner.nextDouble();
    double SheShiDu=(WenDu-32)*5/9;
    SheShiDu=100*Math.round(SheShiDu)/100;
    System.out.println((SheShiDu));
	}

}

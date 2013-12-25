package Test04;

import java.util.Random;

public class Test05 {

	public Test05() {
		// TODO Auto-generated constructor stub
	}

	/**随机产生10个数（要求产生的分数在60到100之间）
	 * @param args找出最高分
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Random random=new Random();
int max=Integer.MIN_VALUE;//int类型的最小值
for(int i=1;i<=10;i++){
	int score=random.nextInt(41)+60;
	System.out.println(score+" ");
	if(max<score){
		max=score;
	}
}
System.out.println();
System.out.println("最高分："+max);
	}

}

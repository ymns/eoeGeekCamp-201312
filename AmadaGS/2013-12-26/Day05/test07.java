package Day05;

import java.util.Scanner;

public class test07 {

	/**
	 * @param args 键盘输入学生姓名，若匹配则输出下表
	 */
	public static void main(String[] args) {
		String[] name={"zhangsan","lisi","wangwu","zhaoliu"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入姓名：");
		String n=scanner.next();
		for(int i=0;i<name.length;i++){
			if(n.equals(name[i])){
				System.out.println(name[i]+":"+i);
			}
		}
	}

}

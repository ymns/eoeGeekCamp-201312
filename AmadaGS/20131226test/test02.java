package Day03;

import java.util.Scanner;

public class test02 {

	/**
	 * @param args练习定义方法，在主函数中调用该方法
	 */
	static String name;
	static char sex;
	static int age;
	static double hight;
	static String type;
	 
	static void Input(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("姓名：");
		name=scanner.next();
		System.out.println("性别：");
		sex=scanner.next().charAt(0);
		System.out.println("年龄：");
		age=scanner.nextInt();
		System.out.println("身高：");
		hight=scanner.nextDouble();
		System.out.println("性格：");
		type=scanner.next();
		
	}
	
	
	//    姗姗    女      外向
	//    王晓超   男    阳光
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Input();
       System.out.println("大家好，我叫"+name+"性别"+sex+"年龄"+age+"身高"+hight+"性格"+type);
       System.out.println("我考试了100分，偶也！");
       System.out.println("我丢了一部手机，呜呜。。");
       
       Input();
       System.out.println("大家好，我是"+name+"性别"+sex+"年龄"+age+"身高"+hight+"性格"+type);
       System.out.println("我们队打篮球得了第一名");
       System.out.println("我成绩有进步了");
	}

}

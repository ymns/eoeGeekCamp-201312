package Day03;

import java.util.Scanner;

public class test03 {

	/**
	 * @param args定义带参数的方法，实参传递给形参
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
	
	 static void say(){
		 System.out.println("我是"+name+" 性别："+sex+" 年龄："+age+" 身高："+hight+" 性格："+type);
	 }
	  
	 static void feeling(String cause,String content){
		 System.out.println(cause);
		 System.out.println(content);
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		say();
		feeling("我中了一百万","晚上睡不着了");
		Input();
		say();
		feeling("丢了一部手机","心情很糟糕");
	
	}
  //   李四   男   闷骚         李刚   男     阳光
}

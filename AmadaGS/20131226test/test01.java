package Day03;

import java.util.Scanner;

public class test01 {

	/**
	 * @param args练习用static来定义类的静态变量
	 */ static String name;
       static  char sex;
       static  double hight;
       static  int age;
       static  String  type;
       
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scanner=new Scanner(System.in);
     System.out.println("姓名：");
      name=scanner.next();
     System.out.println("性别：");
      sex=scanner.next().charAt(0);
     System.out.println("身高：");
      hight=scanner.nextDouble();
     System.out.println("年龄");
     age=scanner.nextInt();
     System.out.println("性格：");
     type=scanner.next();
     System.out.print("大家好，俺叫"+name+"性别"+sex+"身高"+hight+"年龄"+age+"我的性格是"+type);
   //  娜娜     女  活泼
    }    

}

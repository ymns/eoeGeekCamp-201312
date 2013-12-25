package Test04;

import java.util.Scanner;

public class Test11 {

	public Test11() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String uname="zhangfei";
   String upwd="123456";
   Scanner scanner=new Scanner(System.in);
   System.out.println("输入用户名");
   String userName=scanner.next();
   if(!userName.equals(uname)){
	   System.out.println("请先注册");
	   return;
   }
   System.out.println("请输入密码");
   String pwd=scanner.next();
   if(!upwd.equals(pwd.trim())){
	   System.out.println("密码错误");
	   return;
   }
   System.out.println("登陆成功");
	}

}

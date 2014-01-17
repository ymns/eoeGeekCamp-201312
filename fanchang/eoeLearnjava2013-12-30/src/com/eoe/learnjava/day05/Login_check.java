package com.eoe.learnjava.day05;
import java.util.Scanner;


public class Login_check {

	/**
	 * 已知注册用户名:ZhangFei,密码zf007ZF
	 * 编写一个登陆程序,输入用户名和密码
	 * 要求:
	 * 1.用户名不计大小写
	 * 2.密码的大小写要一致
	 * 3.都正确则成功
	 * 4.错误时提示"查无此人",密码错误提示"密码错误",
	 * 验证成功提示"登陆成功"
	 * @param args
	 */
	public static void main(String[] args) {
		String user ="ZhangFei";
		String password="zf007ZF";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入用户名:");
			String usered=scanner.next();
			System.out.println("请输入密码:");	
			String passworded=scanner.next();
			if (!usered.equalsIgnoreCase(user)) {
				System.out.println("查无此人!");
				break;
			} else if (!password.equals(passworded)) {
				System.out.println("密码错误!");
				break;
			} else {
				System.out.println("登陆成功!");
				break;
			}
		} while (true);

	}

}

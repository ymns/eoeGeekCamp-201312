package com.eoe.se1.day01;

import java.util.Scanner;

import com.eoe.se1.day01.button.Button;
import com.eoe.se1.day01.button.OnClickListener;

public class Test_button {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建两个按钮
		Button btnLogin=new Button();
		Button btnRegister=new Button();
		//将两个按钮点击事件响应的代码存在两个按钮的mOnClickListener的属性中
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("执行登陆操作");
				
			}
		});
		
		RegisterListener s=new RegisterListener();
		btnRegister.setOnClickListener(s);
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("1-登陆");
		System.out.println("2-注册");
		int select=scanner.nextInt();
		switch (select) {
		case 1:
			btnLogin.performClick();
			break;
		case 2:
			btnRegister.performClick();
			break;
		}
	}
	static class RegisterListener implements OnClickListener{

		@Override
		public void onClick() {
			System.out.println("执行注册操作");
			
		}
		
	}

}

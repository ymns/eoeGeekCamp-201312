package com.eoe.pre.textday02;

public class Test10 {

	public static void main(String[] args) {
		boolean pass;
		pass=true;//过了
		System.out.println("考试通过："+pass);
		pass=false;//没过
		System.out.println("考试通过："+pass);
		int score=65;
		pass=score>=60;//将score>=60的结果保存在pass变量中
		System.out.println("考试通过："+pass);
	}

}

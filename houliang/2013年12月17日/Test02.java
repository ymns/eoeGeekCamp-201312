package com.eoe.test;

import java.util.ArrayList;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<String>();
		name.add("池泉");
		name.add("张宝林");
		name.add("李伟");
		name.add("梁文峰");
		name.add("王多英");
		name.add("侯亮");
		name.add("乔雨晴");
		name.add("蔡香龙");
		name.add("韩伟");
		Random i=new Random();
		int j=name.size()-1;
		int x=1;
		while(name.size()>0){
			String n=null;
			if(j>0){	
				 n=name.remove(i.nextInt(j));
			}else if(j==0){
				 n=name.remove(0);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			Scanner scanner=new Scanner(System.in);
//			System.out.println("请选择：");
//			int k=scanner.nextInt();
//			System.out.println(k+"."+n);
			System.out.println(x+"."+n);
			if(j>0){
				j--;
			}
			x++;
			
		}
	}
}

package com.eoe.oop.day01;

import java.util.Arrays;

public class Student {

	/**
	 * 从两个学生的相关信息中抽取出属性和方法,封装在Student类
	 * @param args
	 */
	
	//定义五个变量
	public String name;
	public char sex;
	public int age;
	public double height;
	public String type;
	public String inSchool;
	public String inClass;
	
	//构造参数方法
	public Student(String name,int age,double height,String type,
			char sex,String inSchool,String inClass){
		this.name=name;
		this.age=age;
		this.height=height;
		this.sex=sex;
		this.type=type;
		this.inClass=inClass;
		this.inSchool=inSchool;
	}
	

	//创建一个say方法表示要说的话
	public void say(){
		System.out.println("嗨，大家好，俺叫"+name+",今年"
				+age+"岁,身高"+height+"米,俺是一个"
				+type+sex+"士");
		System.out.println("俺在"+inSchool+inClass+"学习");
		System.out.println("俺给大家表演两个变量相交换的算法");				
	}
	
	//创建一个feeling方法表达情感
	public void feeling(){
		System.out.println("俺找到好工作啦!,月新8k");
		System.out.println("嘻嘻...");
	}
	
	//创建一个交换变量的方法
	public void swap(int[] a,int i,int j){
		int c=a[j];
		a[j]=a[i];
		a[j]=c;	
	}
	
	public static void main(String[] args) {
		//第一个学员
		Student student1 = new Student("梁文峰",25,1.7,"豪放的",'男',
				"eoe极客学院","Android1205班");
		student1.say();
		int[] a1={10,5};
		System.out.println(Arrays.toString(a1));
		student1.swap(a1,0,1);
		System.out.println("变");
		System.out.println(Arrays.toString(a1));
		student1.feeling();
		
		
		//第二个学员
		Student student2 = new Student("梁文峰",25,1.7,"豪放的",'男',
				"eoe极客学院","Android1205班");
		student2.name="高珊";
		student2.sex='女';
		student2.height=1.69;
		student2.age=24;
		student2.type="活泼的";
		student2.inSchool="eoe极客学院";
		student2.inClass="Android1205班";
		student2.say();
		int[] a2={100,1000};
		System.out.println(Arrays.toString(a2));
		student2.swap(a2,0,1);
		System.out.println("变");
		System.out.println(Arrays.toString(a2));
		student2.feeling();
	}
}

package com.eoe.oop.day01;

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
	//无参的
	public Student() {
		super();
	}


	//构造5个参数的方法
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
		
	}
}

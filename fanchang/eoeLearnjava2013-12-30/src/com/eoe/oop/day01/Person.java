package com.eoe.oop.day01;

public class Person {

	/**
	 * 创建一个person类
	 * 
	 * @param args
	 */
	// 声明五个变量
	public String name;
	public int age;
	public double height;
	public char sex;
	public String type;

	// 无参构造(器)方法,JVM默认提供一个构造方法
	public Person() {
		name = "刘亦菲";
		age = 18;
		height = 1.75;
		sex = '女';
		type = "大方的";
	}

	// 一个参数
	public Person(String name) {
		super();
		this.name = name;
	}

	// 2个参数
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 3个参数
	public Person(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	// 4个参数
	public Person(String name, int age, double height, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.sex = sex;
	}

	// 五个参数
	public Person(String name, int age, double height, char sex, String type) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.sex = sex;
		this.type = type;
	}

	public void say() {
		System.out.println("嗨,大家好我叫:" + name + ", 今年 " + age + ", 身高" + height
				+ ", 我是一个" + type + sex + "士");
	}

	public void feeling(String cause, String content) {
		System.out.print(cause);
		System.out.println(content);
	}

	public static void main(String[] args) {
		// Person p1 = new Person();
		// p1.name = "张飞";
		// p1.age = 23;
		// p1.height = 1.8;
		// p1.sex = '男';
		// p1.type = "豪放的";
		// p1.say();
		// p1.feeling("俺找到好工作啦，月薪8k", "哈哈~");
		// p1.feeling("俺失恋啦!", "哇哇~");
		//
		// Person p2 = new Person();
		// p2.name = "李多多";
		// p2.age = 25;
		// p2.height = 1.7;
		// p2.sex = '女';
		// p2.type = "温柔的";
		// p2.say();
		// p2.feeling("俺捡了五百万", "嘻嘻~");
		// p2.feeling("俺被人骗了五百万", "呜呜~");
		// Person p = new Person("刘亦菲",21,1.86,'女',"温柔的"); //内部测试
		// p.say();
		// p.feeling("俺捡钱了","   哈哈");
	}

}

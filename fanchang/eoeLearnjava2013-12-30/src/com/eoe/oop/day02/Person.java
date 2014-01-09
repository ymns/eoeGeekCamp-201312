package com.eoe.oop.day02;

public class Person {

	/**
	 * @param args
	 */
	//定义五个共有的变量
	public String name;
	public char sex;
	public int age;
	public double height;
	public String type;

	// 说话，打招呼,say方法是非静态方法
	public void say() {
		System.out.println("嗨，大家好，俺叫" + name + "，今年" + age + "岁,身高" + height
				+ "米,俺是一个" + type + sex + "士");
	}

	// feeling方法是非静态方法
	public void feeling(String cause, String content) {
		System.out.println(cause);
		System.out.println(content);
	}

	// 无参构造(器)方法,JVM默认提供一个构造方法
//	public Person() {
//		name = "张三";
//		sex = '男';
//		age = 18;
//		height = 1.7;
//		type = "活泼的";
//	}

//带参构造方法
	public Person(String name, char sex, int age, double height, String type) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.type = type;
	}
//重写toString
	@Override
	public String toString() {
		return this.name;//返回人名
	}
//重写equals
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {               //obj为空,则返回false
			return false;
		}
		Person other=null;
		if (obj instanceof Person) {   //判断能否转换
			other=(Person) obj;        //强制转换并赋值给other
		}else {
			return false;
		}if (obj==this) {          		//obj的地址和这个对象的地址相等,
			return true;
		}
		return this.name.equals(other.name)    //返回并比较
				&&this.sex==other.sex&&
				this.age==other.age&&
				((Math.abs(this.height-other.height))<0.0000001)&&
				this.type.equals(other.type);
	}

	public static void main(String[] args) {
		Person p1=new Person("张飞",'男',21,1.84,"豪放的");
		Person p2=new Person("张飞",'男',21,1.85,"豪放的");
		if (p1.equals(p2)) {       //比较p1 和 p2 的属性是否完全相等
			System.out.println("是一个人!");
		}else{
			System.out.println("不是一个人!");
		}
	}

}

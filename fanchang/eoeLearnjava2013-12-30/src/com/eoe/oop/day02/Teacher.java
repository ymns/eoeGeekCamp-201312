package com.eoe.oop.day02;

import java.util.Arrays;

import com.eoe.oop.day01.Person;

public class Teacher extends Person {

	/**
	 * @param args
	 */
	public String inClass;
	public String inWork;
	//无参构造方法,调用父类的无参构造方法
	public Teacher(String name, char sex, double height, String inClass,
			String inWork) {
		super(name, sex, height);
		this.inClass = inClass;
		this.inWork = inWork;
	}
	//交换值
	public void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	//说话的方法,继承Person say()
	public void say() {
		super.say();
		System.out.println("俺在" + inClass + inWork + "任教");
	}

	public static void main(String[] args) {
		Teacher t1 = new Teacher("李明", '男', 1.78, "极客学院", "eoeSchool");
		t1.age = 24;
		t1.type = "和蔼的";
		t1.say();
		t1.feeling("俺找到好工作啦", "  哈哈");
		System.out.println("俺给大家表演两个变量值互换的算法");
		int[] a = { 155, 100 };
		System.out.println(Arrays.toString(a));
		t1.swap(a, 0, 1);
		System.out.println("变" + Arrays.toString(a));
	}

}

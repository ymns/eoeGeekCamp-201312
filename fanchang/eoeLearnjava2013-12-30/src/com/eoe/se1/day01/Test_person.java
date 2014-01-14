package com.eoe.se1.day01;


import com.eoe.oop.day03.entity.Teacher_;
import com.eoe.oop.day03.entity.Person_;
import com.eoe.oop.day03.entity.Student_;



public class Test_person {

	/**
	 * 匿名内部类
	 * 测试person_类
	 * @param args
	 */
	public static void main(String[] args) {
		//创建数组保存一组人类的对象
		Person_ [] people=new Person_[4];
		//将四个人的对象保存在集合中
		people[0]=new Student_("张飞", '男', 23, 1.87, "疯狂的",
				"eoe极客学院", "eoe1205班");
		people[1]=new Teacher_("张大飞",'男',44,1.77,"和蔼的",
				"eoe极客学院","讲师");
		people[2]=new Student_("李明", '女', 24, 1.78, "温柔的",
				"eoe极客学院", "eoe1205班");
		//以匿名内部类的形式将建对象并保存在集合中
		people[3]=new Person_("刘亦菲",'女',21,1.67,"文静的") {
			//继承Preson类的所有属性,并新增两个属性
			String unit="中央戏曲学院";
			String worker="演员";
			//重写父类say()
			@Override
			public void say() {
				super.say();
				System.out.println("俺是"+unit+"做"+worker);
			}
			//实现父类的抽象方法
			@Override
			public void doing() {
				System.out.println(name+"在演戏~~");
			}
		};
		//调用集合中的各对象说话,做事
		for (Person_ p:people) {
			p.say();
			p.doing();
			System.out.println("***********");
		}
		
		
	}

}

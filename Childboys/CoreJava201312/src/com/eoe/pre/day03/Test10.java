package com.eoe.pre.day03;

import java.util.ArrayList;

import com.eoe.pre.day03.entity.Person_;
import com.eoe.pre.day03.entity.Student_;
import com.eoe.pre.day03.entity.Teacher_;

public class Test10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person_> people = new ArrayList<Person_>();
		people.add(new Student_("张小飞", '男', 22, 1.79, "豪放的", "eoe",
				"eoe210312班"));
		people.add(new Teacher_("张大飞", '男', 32, 1.79, "豪放的", "eoe", "讲师"));
		people.add(new Student_("王小飞", '女', 22, 1.79, "豪放的", "eoe",
				"eoe210312班"));
		people.add(new Person_("刘亦菲",'女',28,1.69,"温柔的") {

			@Override
			public void doing() {
				System.out.println(this.getName()+"正在表演....");
			}
		});
		
		for (Person_ p : people) {
			p.say();
			p.doing();
			System.out.println("*************");
		}
	}

}

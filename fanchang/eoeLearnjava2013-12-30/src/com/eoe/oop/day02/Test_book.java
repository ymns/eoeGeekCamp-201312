package com.eoe.oop.day02;

public class Test_book {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strPerson="李刚:男:33:1.67:快乐的";
		String strBook="1:《疯狂Java》:ISBN18005:85";
		String[] data=strPerson.split(":");             //同":"分隔开存入数组
		Person author=new Person(data[0],data[1].charAt(0)
				,Integer.parseInt(data[2])
				,Double.parseDouble(data[3]),data[4]);//创建author对象
		data=strBook.split(":"); 
		Book b1=new Book(Integer.parseInt(data[0]), data[1], author,data[2],
				Double.parseDouble(data[3]));			//创建b1对象
		//创建对象b2
		Book b2=new Book(2, "《疯狂android》",author, "ISBN18003", 58.5);
		String c=b1.toString();           //返回b1的书名
		System.out.println(c);			  
		boolean d=b1.isbn.equals(b2.isbn);  //比较b1和b2是否是一本书
		System.out.println("book1和book2是一本书   !"+d);
		c=b1.details();
		System.out.println("book1的属性:\n"+c);
		c=b2.details();
		System.out.println("book2的属性:\n"+c);
		System.out.println("作者和大家打招呼了~");
		author.say();
		
	}

}

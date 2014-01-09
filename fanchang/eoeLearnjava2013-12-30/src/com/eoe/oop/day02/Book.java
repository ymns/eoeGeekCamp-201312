package com.eoe.oop.day02;

public class Book {

	/**
	 * 4、已知以下数据
	String strPerson="李刚:男:33:1.67:快乐的";
	String strBook="1:《疯狂Java》:ISBN18005:85";
	(1)在com.eoe.oop.day02包下创建Book对象，该对象包含以下属性：
		id：代表书的编号；
		name：代表书名；
		author:代表作者，该属性的类型是Person；
		isbn:代表书号；
		price:代表书价。
	(2)重写toString()，返回书名。
	(3)重写equals(),两本书相等的条件是书号相等。
	(4)编写public String details()，该方法显示书的所有属性值。
	 * @param args
	 */
//定义了4个参数
	public int id;
	public String names;
	public String isbn;
	public double price;

	
//构造有参方法	
	public Book(int id, String names, String isbn, double price) {
		super();
		this.id = id;
		this.names = names;
		this.isbn = isbn;
		this.price = price;
	}
	
//重写toString
	@Override
	public String toString() {
		
		return this.names;
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
		return this.isbn==obj;
	}
	public String details(){
		System.out.println("编号:"+id+",书名"+names+
				"书号:"+isbn+"价格:"+price);
		Person.say();
	}

	public static void main(String[] args) {
		Author author = new Author("李刚", '男', 33, 1.67, "快乐的");
		Book book1=new Book(1, "《疯狂Java》", "ISBN18005", 85);
		Book book2=new Book(1, "《疯狂Java》", "ISBN18005", 85);
		System.out.println(book1.equals(book2));
		String strPerson="李刚:男:33:1.67:快乐的";
		String strBook="1:《疯狂Java》:ISBN18005:85";
		
	}

}

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
	public int id;        	//编号
	public String names;    //书名
	public String isbn;     //书号
	public double price;    //价格
	public Person author;   //作者

	
//构造有参方法	
		
	public Book() {
		super();
	}


	public Book(int id, String names,Person anthor
				,String isbn, double price) {
		super();
		this.id = id;
		this.names = names;
		this.author=anthor;
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
	public boolean equals(Object obj) {    //obj目标地址
		if (obj==null) {               //obj为空,则返回false
			return false;
		}
		Book other=null;
		if (obj instanceof Person) {   //判断能否转换
			other=(Book) obj;        //强制转换并赋值给other
		}else {
			return false;
		}if (obj==this) {          		//obj的地址和这个对象的地址相等,
			return true;
		}
		return this.isbn.equals(other.isbn);
	}
	public String details(){
		return "书名:"+names+
				   "\n作者:"+author+   
				   "\n书号:"+isbn+
				   "\n书价:"+price+"元";
	}

	public static void main(String[] args) {


	}

}

package Day04;

public class test03 {

	/**
	 * @param ars练习使用do-while循环输出A-Z以及对应的unicode值
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*int i=65;
	do{
		System.out.println((char)i+":"+i);
		i++;
	}while(i<65+26);
	}*/
	
	char i='A';
	do{
		System.out.println(i+":"+(int)i);
		i++;
	}while(i<='Z');	
}
}
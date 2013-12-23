package Test01;

public class Test09 {

	public Test09() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   for(int i=1;;i++){
	   if(i<20){
		   System.out.println("罚做俯卧撑"+i+"次");
	   }else if(i<100){
		   System.out.println("呼哧...呼哧..."+i+"次");
	   }else{
		   break;
	   }
   }
   System.out.println("体力不支，最终OVER!");
	}

}

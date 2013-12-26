package Day03;

public class test04 {

	/**
	 * @param args 定义带返回值的方法
	 * 	 */
	
	
	static double  pround (double value, int n){
		double pow10=Math.pow(10,n);//计算10的N次方
		double result=value*pow10;
		result=Math.round(result);
		result=result*1.0/pow10;
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       double  result=pround(6.256,2);
       System.out.println(result);
	}

}

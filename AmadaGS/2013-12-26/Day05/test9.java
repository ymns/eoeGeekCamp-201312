package Day05;

public class test9 {

	/**
	 * @param args 双重循环输出100以内的数
	 */
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(i*10+j<10){
					System.out.print(" "+i*10+j);
				}else {
				System.out.print(i*10+j+" ");
			}
			
				
			}
			System.out.println();
		}

	}

}

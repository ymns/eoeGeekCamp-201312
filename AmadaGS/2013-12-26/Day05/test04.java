package Day05;

public class test04 {

	/**
	 * @param args¥Ú”°æ≈æ≈≥À∑®±Ì
	 */
	public static void main(String[] args) {
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+" ");
				if(i*j<10){
					System.out.println(" ");
				}
			}
			System.out.println();
		}

	}

}

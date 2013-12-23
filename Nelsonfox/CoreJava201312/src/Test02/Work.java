package Test02;

public class Work {
	public static void main(String[] args) {
		int i=1;
		while(i<=5){
			if(i%2==1){
				continue;
			}
			System.out.print(i++);
		}
	}
}

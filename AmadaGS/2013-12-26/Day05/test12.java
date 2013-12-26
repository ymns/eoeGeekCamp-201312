package Day05;

import java.util.Random;

public class test12 {

	/**
	 * @param args·¢ÅÆ
	 */
	public static void main(String[] args) {
	/*String[] cards={"ºìÌÒ2","ºìÌÒ3","ºìÌÒ4",
			        "ºìÌÒ5","ºìÌÒ6","ºìÌÒ7",
			        "ºìÌÒ8","ºìÌÒ9","ºìÌÒ10",
			        "ºìÌÒJ","ºìÌÒQ","ºìÌÒK","ºìÌÒA"};
	 String[] player={"ÕÅ·É","Íõ·Æ","ÁõÒà·Æ"};
	 for(int i=0;i<cards.length;i++){
		 System.out.println(player[i%2]+":"+cards[i]);
	 }*/
		String[] cards={"ºìÌÒ2","ºìÌÒ3","ºìÌÒ4",
		                "ºìÌÒ5","ºìÌÒ6","ºìÌÒ7",
		                "ºìÌÒ8","ºìÌÒ9","ºìÌÒ10",
		                "ºìÌÒJ","ºìÌÒQ","ºìÌÒK",
		                "ºìÌÒA","ºìÌÒ0","ºìÌÒw"};
		String[] player={"ÕÅ·É","Íõ·Æ","ÁõÒà·Æ"};
		
		Random random=new Random();
		for(int i=cards.length-1;i>0;i--){
			int j=random.nextInt(i);
			
			String temp=cards[i];
			       cards[i]=cards[j];
			       cards[j]=temp;
			       System.out.println(player[i%3]+":"+cards[i]);
		}
		System.out.println(player[0]+":"+cards[0]);
		
		
		
		
		
		
		
	}

}

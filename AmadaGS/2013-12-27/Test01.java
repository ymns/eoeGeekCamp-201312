package JavaDay05;

import java.util.Arrays;

public class Test01 {

	/**
	 * @param 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={20,30,56,78,13};
		System.out.println("初始数组为:"+Arrays.toString(a));
/*		for(int i=1;i<a.length-1;i++){
			if(a[0]<a[i]){
			int	t=a[0];
			a[0]=a[i];
			a[i]=t;
			}
			System.out.println(Arrays.toString(a)); 
		}
		System.out.println("第1次交换后的数组:"+Arrays.toString(a));	
		
	   	for(int i=2;i<a.length-1;i++){
	   		if(a[1]<a[i]){
	   			int t=a[1];
	   			a[1]=a[i];
	   			a[i]=t;
	   		}
	   	}
	   	System.out.println("第2次交换后的数组:"+Arrays.toString(a));
	   	for(int i=3;i<a.length-1;i++){
   		if(a[2]<a[i]){
   			int t=a[2];
   			a[2]=a[i];
   			a[i]=t;
   		}
   	}
   	   System.out.println("第3次交换后的数组:"+Arrays.toString(a));
   	   for(int i=4;i<a.length-1;i++){
		if(a[3]<a[i]){
			int t=a[3];
			a[3]=a[i];
			a[i]=t;
		}
	}
   	   System.out.println("第4次交换后的数组:"+Arrays.toString(a));
	}*/
		for(int i=1;i<a.length-1;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					int t=a[j];
					a[j]=a[i];
					a[i]=t;
				}
			}
		}
		System.out.println("倒序排序的结果："+Arrays.toString(a));
	}
}
		
		
	
	
	


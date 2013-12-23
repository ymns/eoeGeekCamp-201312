package Test03;

public class Learn06 {

	public Learn06() {
		// TODO Auto-generated constructor stub
	}

	/**while循环
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=1;
while(true){
	if(i<=20){
		System.out.println("上课迟到，罚做俯卧撑"+i+"次");
	}else if(i<100){
		System.out.println("呼哧...呼哧..."+i+"次");
		}else{
			break;
		}
	i++;
}
System.out.println("体力不支，最终Over");
	}

}

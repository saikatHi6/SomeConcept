import java.util.Arrays;

public class ArrayRotation {
	
	int a;
	
	public ArrayRotation() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayRotation(int a) {
		
		this();
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,5,6,7,8};
		int count = 1;
		
		Arrays.stream(rotation(arr, count)).forEach(System.out::print);
		System.out.println();
		System.out.println(reverse(12345));
	}
	
	static int[] rotation (int[] arr,int count){
		
		while(count!=0){
		int temp = arr[arr.length-1];
		
			for(int i=arr.length-1;i>0;i--){
				arr[i] = arr[i-1];
			}
		arr[0] = temp;	
		count--;
		}
		return arr;
	}
	
	static int reverse(int a){
		if(a==0)
			return 0; 
		System.out.println(a%10);
		int rem = a%10;
		int rev =   reverse(a/10)*10 ;
		return rev +  a%10;
	}

}

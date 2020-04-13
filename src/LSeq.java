import java.lang.reflect.Array;

class Func{
	class TestHack{}
}

public class LSeq {

	
	
	private static int countSeq = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,3,1,4,6,0};
		int[] temp = new int[arr.length];
		int size = arr.length;
		int sub = 0;
		
		int a1 = 80;
		int b1 = 10;
		
		int c = ++a1*a1/100+b1;
		
		System.out.println(c);
		
		Func f = new Func();
		Func.TestHack t = f.new TestHack();
		
		
		
		
		
		System.out.println(sequence(arr,temp,sub,0,countSeq));
	}

	
	public static int sequence(int[] arr,int[] temp,int sub,int index,int countSeq){
		if(sub==3 && ((temp[0]>temp[1] && temp[1]>temp[2]) || (temp[0]<temp[1] && temp[1]<temp[2]))){
			countSeq++;
			System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+" ");
			return countSeq;
		}
		else{
				for(int i=index;i<arr.length;i++){
					temp[sub] = arr[i];
					if(sub<=2){
						countSeq = sequence(arr,temp,sub+1,i+1,countSeq);
					}
				}
		}
		return countSeq;
	}
}

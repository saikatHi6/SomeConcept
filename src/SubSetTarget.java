import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetTarget {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int weights[] = {15, 22, 14, 26, 32, 9, 16, 8}; 
	    int target = 53; 
		Arrays.sort(weights);
		int total = 0;
		for (int i = 0; i < weights.length; i++) {
			total+= weights[i];
		}
		int[] subA = new int[weights.length];
		if(weights[0]<=total && total>=target){
			subset(weights,subA,weights.length,0, 0, 0, target);
		}
		
	}
	
	public static void print(int[] subArr){
		for (int i = 0; i < subArr.length; i++) {
			System.out.println(" "+subArr[i]);
		}
	}
	
	public static void subset(int[] arr,int[] sub,int arrS,int subS,int sum,int index,int target){
		
		if(sum==target){
			print(sub);
			System.out.println("============");
			if(index+1<arrS && sum-arr[index]+arr[index+1]<=target){
				subset(arr, sub,arrS,subS-1, sum-arr[index], index+1, target);
			}
			return;
		}
		else{
			
			if(index<arrS && sum+arr[index]<=target){
				
				for (int i = index; i < arr.length; i++) {
					
					sub[subS] = arr[i];
					if(sum+arr[i]<=target){
						subset(arr,sub,arrS,subS+1, sum+arr[i], i+1, target);
					}
						
					/*else if(i<arr.length)
						sub.remove(arr[i]);*/
				}
				
				
			}
			
			
			
		}
		
		
		
	}

}

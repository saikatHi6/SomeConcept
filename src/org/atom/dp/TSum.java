package org.atom.dp;

public class TSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1,1};
		System.out.println(freqSum(arr, 5));
		System.out.println(targetSum(arr, 0, 5, 0));
	}
	
	
	public static int targetSum(int[] arr,int sum,int t,int index){
		if(index==arr.length)
			return sum==t?1:0;
		return targetSum(arr, sum+arr[index], t, index+1) + targetSum(arr, sum-arr[index], t, index+1);
	}
	
	
	
	
	
	
	public static int freqSum(int[] arr,int t){
		int count = 0;
		
		for(int i=0;i<arr.length;i++){
			int sum = 0;
			for(int j=0;j<arr.length;j++){
				
					if(sum+arr[i]<=t){
						sum+=arr[i];
					}
					else{
						sum-=arr[i];
					}
				
			}
			if(sum==t)
				count++;
		}
		
		return count;
	}

}

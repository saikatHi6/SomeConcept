package org.atom.datastructure;

import java.util.concurrent.ConcurrentHashMap;

public class TestSumMaxK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10,3,4,9,5,7,1,14};

		System.out.println(findMax(arr, 3));;
		
		
	}
	
	public static int findMax(int[] arr,int k){

		
		
		int fMax = arr[0];
		int sMax = 0;
		int start = 0;
		int sum = 0;
		int[] dp = new int[arr.length];
		for(int end=1;end<arr.length;end++){
			
			if(end-start+1>k){
				start++;
				sum = sum + fMax;
				fMax = sMax;
			}
			if(sMax<arr[end]){
				sMax = arr[end];
			}
			if(fMax<sMax){
				int temp = sMax;
				fMax = sMax;
				sMax = temp;
			}
		
		}

		return sum;

	}

}

package org.atom.dp.recursion;

import java.util.ArrayList;
import java.util.List;

public class ThreeValueTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={5,1,15,10,3};
		List<Integer> list = targetSum(arr, 0, 19);
		list.stream().forEach(System.out::print);
	}
	
	static List<Integer> targetSum(int[] arr,int index,int sum){
		if(arr.length==index) return null;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			/*if(index==i)
				continue;*/
			int bala = sum-arr[index];
			if(arr[i]==bala){
				
				list.add(arr[i]);
				list.add(sum-arr[i]-arr[index]);
				list.add(arr[index]);
				return list;
			}
			if(bala>0)
				targetSum(arr, index+1, sum-arr[i]);
			
			
		}
		
		
		return list;
	}

}

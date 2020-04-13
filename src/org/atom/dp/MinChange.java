package org.atom.dp;

import java.util.Collections;
import java.util.List;

public class MinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,10};
		int c = 6;
		int[] cache = new int[c+1];
		for (int i = 1; i < cache.length; i++) {
			cache[i] = -1;
		}
		System.out.println(minChange(arr, c, cache));

		List<String> exList = null;
		List<String> EX_FIELDS = Collections.unmodifiableList(exList);
	}

	public static int minChange(int[] arr,int change,int[] cache){
		if(cache[change]>=0) return cache[change]; 
		int minnCount = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(change-arr[i]>=0){
				int currentChange = minChange(arr, change-arr[i], cache);
				if(currentChange < minnCount){
					minnCount = currentChange;
				}
			}
		}

		cache[change] = 1+ minnCount;
		return cache[change];
	}



}

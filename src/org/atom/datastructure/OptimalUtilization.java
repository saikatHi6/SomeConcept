package org.atom.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OptimalUtilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target = 10;
		int curMax = 0;
		List<int[]> targetList = new ArrayList<int[]>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int val = a[i][1]+b[j][1];
				
				if(val>curMax && val<=target){
					
					if(curMax<val){
						
							for (int k = 0; k < targetList.size(); k++) {
								targetList.remove(k);
							}
						
					}
					
					curMax = val;
					
					targetList.add(new int[]{a[i][0],b[j][0]});
				}
			}
		}

		for (int k = 0; k < targetList.size(); k++) {
			System.out.println(targetList.get(k)[0]+", "+targetList.get(k)[1]);
		}
		
	}

}

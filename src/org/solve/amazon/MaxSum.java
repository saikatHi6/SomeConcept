package org.solve.amazon;

public class MaxSum {

	public static void main(String[] args) {

		int[] arr= {3, 2, 5, 10, 7};
		
		System.out.println(calMax(arr));
	}
	
	
	public static int calMax(int[] arr){
		int target = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 2; j < arr.length; ) {
				
				j = j+2;
			}
		}
		
		return target;
	}

}

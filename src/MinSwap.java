import java.util.ArrayList;
import java.util.List;

public class MinSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2, 1, 5, 6, 3};
	    int n = arr.length;
	    int k = 3;
	    System.out.print(minSwap(arr, k) + "\n");
	 
	    int arr1[] = {2, 7, 9, 5, 8, 7, 4};
	    n = arr1.length;
	    k = 5;
	    System.out.print(minSwap(arr1, k));		
		
		int arr2[] = {2, 1, -5, 6, -3};
		MaxDiff(arr2, 5, 0, 0);
	}
	
	static void MaxDiff(int in[], int sz, int start, int end) {
		   int min = 0;
		   int maxDiff = 0;
		   start = end = 0;
		   for (int i = 0; i < sz; i++) {
		       if (in[i] < in[min])
		           min = i;
		       int diff = in[i] - in[min];
		       if (diff > maxDiff) {
		           //start = min;
		           //end = i;
		           maxDiff = diff;
		       }
		   }
		   
		   System.out.println("Max Diff: "+maxDiff);
		}
	
	
	public static int minSwap(int[] arr,int k){
		int swapC = 0;
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<=k){
				
				if(count!=i){
					int temp = arr[count];
					arr[count] = arr[i];
					arr[i] = temp;
					swapC++;
				}
				count++;
			}
		}
		
		
		return swapC;
	}
	
	

}

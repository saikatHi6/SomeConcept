import java.util.Arrays;
import java.util.HashMap;

public class ShortestWindowSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,5,3,7,10,9,12};
		//int[] arr = {1,3,2,0,-1,7,10};
		//int[] arr = {3,2,1};
		//int[] arr = {1,2,3};
		//Arrays.sort(arr);
		System.out.println(sort(arr));
	}
	
	public static int sort(int[] arr) {
	    // TODO: Write your code here
	    int start = 0;
	    int end = arr.length-1;

	    while(start<end && arr[start]<arr[end] ){
	      if(start==0 && end==arr.length-1){
	        end--;
	      }
	      else {
	        if(arr[end]<arr[end-1]){
	          end--;
	        }
	        if(arr[start]<arr[start+1]){
	          start++;
	        }
	        if(arr[end]>arr[end-1] &&  arr[start]>arr[start+1])
	        		break;
	      }
	      
	    }


	    return (end==start)?0:end-start+1;
	  }

}

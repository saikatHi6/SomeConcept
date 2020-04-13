import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.HandlerBase;

public class AllMissingNumbers {
	
	
	private  class MyTest{
		
		private int i;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={5, 4, 7, 2, 3, 5, 3};	
		List<Integer> list = findNumbers(arr);
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.containsKey(1);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
	
	private void pub() {
		// TODO Auto-generated method stub
		MyTest t = new MyTest();
		t.i = 1;
	}
	
	public static List<Integer> findNumbers(int[] nums) {
	    List<Integer> missingNumbers = new ArrayList<>();
	    // TODO: Write your code here
	    int i=0;
	    while(i<nums.length){
	        if(nums[i]!=nums[nums[i]-1]){
	          swap(nums,i,nums[i]-1);
	          
	        }
	        else{
	          i++;
	        }

	    }
	    for(i=0;i<nums.length;i++){
	        if(nums[i]!=i+1)
	            missingNumbers.add(nums[i]);
	    }


	    return missingNumbers;
	  }

	  public static void swap(int[] arr,int i,int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	    
	  }
	  
	  

}

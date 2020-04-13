import java.util.Arrays;
import java.util.Scanner;

public class Practice {

	public static void main(String args[] ) throws Exception 
	{
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		
		int[] arr = new int[num1];
		
		for(int i=0;i<num1;i++)
		    arr[i] = s.nextInt();
		
		Arrays.sort(arr);
		
		System.out.print(findPos(arr,0,num1,num2));
		
		
	}
	
	public static int findPos(int[] arr,int low,int high,int val){
	    
	    if(low==high){
	    	if(low==0)
	    		return 0;
		    if(high==arr.length)
		    	return high;
	    }
	        
	     
	    int mid = (low+high)/2;
	    
	    if(arr[mid]==val)
	        return mid;
	    if(low!=0 && high!=arr.length && arr[mid+1]>val && arr[mid-1]<val)
	    	return mid;
	    else if(arr[mid]>val )    
        		return findPos(arr,low,mid,val);
        else if (arr[mid]<val ) {
        	return findPos(arr,mid+1,high,val);
		}
               
        return -1;
	    
		}
	
	
}

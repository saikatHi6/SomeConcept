import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class RussianDoll {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = sc.nextInt();
		}
		//alterNative(arr);
		Arrays.sort(arr);
		int maaxDup = 0;
		int count = 1;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]==arr[i+1])
				count++;
			else
				count = 1;
			if(count>maaxDup)
				maaxDup = count;
		}
		System.out.println(maaxDup);
	}

	public static void alterNative(int[] arr){
		int k = 8;
		int n = arr.length;
		for (int i = 0; i< n; i++) 
            arr[(arr[i]%k)] += k; 
  
        // Find index of the maximum repeating element 
        int max = arr[0], result = 0; 
        for (int i = 1; i < n; i++) 
        { 
            if (arr[i] > max) 
            { 
                max = arr[i]; 
                result = i; 
            } 
        } 
		System.out.println(result);
	}
	
	
}

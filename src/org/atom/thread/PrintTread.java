package org.atom.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintTread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int[] nums = {1, 5, 6, 4, 3, 2};
		int i=1;
	    for(int k=0;k<nums.length;k++){
	        int index = nums[i-1];
	        if( nums[i-1]!=nums[index-1]){
	        nums[i-1] = nums[index-1];
	        nums[index-1] = index;
	        i = nums[i-1];
	        }
	        else{
	        	i++;
	        }
	    }
		
		
		Thread t1 = new Thread(()->{
			System.out.println("Thtread 1");
		});
		Thread t2 = new Thread(()->{
			System.out.println("Thtread 2");
		});
		Thread t3 = new Thread(()->{
			System.out.println("Thtread 3");
		});
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		
		t3.join();
	}

}

package org.atom.datastructure;

public class HeapSort{

	
	
	public static void main(String[] args){
		
		int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length;
		
		HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
        
        for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
	}
	

	public void sort(int[] arr){
	
		int n = arr.length;
		
		for(int i=n/2-1;i>=0;i--){
			hepify(arr,n,i);
		}
	
		for(int i=n-1;i>=0;i--){
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			hepify(arr,i,0);
		
		}
	
	
	}
	
	
	public void hepify(int[] arr,int size,int pos){
	
		int largest = pos;
		int left = 2*pos +1;
		int right = 2*pos +2;
		
		if(left<size && arr[largest]>arr[left])
			largest = left;
		if(right<size && arr[largest]>arr[right])
			largest = right;
		
		if(largest!=pos){
			int temp = arr[pos];
			arr[pos] = arr[largest];
			arr[largest] = temp;
			
			hepify(arr,size,largest);
		}		
		
	
	
	}




}

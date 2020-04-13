package org.atom.datastructure;

import javax.print.attribute.standard.Media;

public class MinHeap {
	
	int[] heap;
	int maxSize;
	int size;
	
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[maxSize+1];
	}
	
	int left(int pos){
		return 2*pos;
	}
	
	int right(int pos){
		return 2*pos+1;
	}
	
	void swap(int fPos,int nPos){
		int temp = heap[fPos];
		heap[fPos] = heap[nPos];
		heap[nPos] = temp;
	}
	
	boolean isLeaf(int pos){
		if(pos>=size/2 && pos<=size){
			return true;
		}
		return false;
	}
	
	int parent(int pos){
		return pos/2;
	}
	
	void insert(int val){
		if(maxSize<=size)
			return;
		heap[++size] = val;
		int curPos = size;
		while(heap[curPos]<heap[parent(curPos)]){
			swap(curPos, parent(curPos));
			curPos = parent(curPos);
		}
	}
	
	private void minHeapify(int pos) 
    { 
  
        // If the node is a non-leaf node and greater 
        // than any of its child 
        if (!isLeaf(pos)) { 
            if (heap[pos] > heap[left(pos)] 
                || heap[pos] > heap[right(pos)]) { 
  
                // Swap with the left child and heapify 
                // the left child 
                if (heap[left(pos)] < heap[right(pos)]) { 
                    swap(pos, left(pos)); 
                    minHeapify(left(pos)); 
                } 
  
                // Swap with the right child and heapify 
                // the right child 
                else { 
                    swap(pos, right(pos)); 
                    minHeapify(right(pos)); 
                } 
            } 
        } 
    } 
	
	void minHepify(int pos){
		if(isLeaf(pos))
			return;
		if(heap[pos]>heap[left(pos)] || heap[pos]>heap[right(pos)]){
			if(heap[left(pos)]<heap[right(pos)]){
				swap(pos, left(pos));
				minHepify(left(pos));
			}
			else{
				swap(pos, right(pos));
				minHepify(right(pos));
			}
		}
	}
	
	public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHepify(pos);
        } 
    } 
	
	int pop(){
		int val = heap[1];
		heap[1] = heap[size--];
		minHeapify(1);
		heap[size+1] = val;
		return val;
	}

	
	public static void main(String[] args) {

		int arr[] = { 2, 6, 3, 12, 56, 8 }; 
		MinHeap minHeap = new MinHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			minHeap.insert(arr[i]);
		}
		//minHeap.minHeap();
		while(minHeap.size>0){
			System.out.println(minHeap.pop());
		}
	}

}

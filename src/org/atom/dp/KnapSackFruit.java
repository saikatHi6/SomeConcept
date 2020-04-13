package org.atom.dp;

public class KnapSackFruit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] profits = {1,6,10,16};
		int[] weights = {1,2,3,5};
		System.out.println(solveKnapsack(profits, weights, 7));
		System.out.println(solveKnapsackWithLessSpace(profits, weights, 7));
	}
	
	static int solveKnapsackWithLessSpace(int[] profits, int[] weights, int capacity) {
	    //TODO: Write - Your - Code
	      int[] cache = new int[capacity+1];
	      int j = 0; 
	      for(Integer profit:profits){

	          int[] newCache = new int[capacity+1];
	           
	          for(int i=0;i<=capacity;i++){
	              if(i<weights[j]){
	                newCache[i] = cache[i];
	              }
	              else{
	                newCache[i] = Math.max(profit+cache[i-weights[j]],cache[i]);
	              }
	          }
	        cache = newCache;
	        j++;
	      }
	    return cache[capacity];
	  }
	
	
	
	static int solveKnapsack(int[] profits, int[] weights, int capacity) {
	    //TODO: Write - Your - Code
	      int[][] cache = new int[profits.length][capacity+1];

	      for(int i=1;i<=capacity;i++){
	    	  cache[0][i] = profits[0];
	      }
	      
	      
	      
	      for(int j=1;j<profits.length;j++){

	          //int[] newCache = new int[capacity+1];
	          for(int i=1;i<=capacity;i++){
	              if(i<weights[j]){
	            	  cache[j][i] = profits[j-1];
	              }
	              else{
	            	  cache[j][i]  = Math.max(profits[j]+cache[j-1][i-weights[j]],cache[j-1][i]);
	              }
	          }
	      }
	    return cache[profits.length-1][capacity];
	  }

}

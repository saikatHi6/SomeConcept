package org.atom.dp;

import java.util.HashMap;
import java.util.Map;

public class KnapSackP {

	static class Item{
		int weight;
		int value;
		public Item(int weight,int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item[] items = {new Item(1, 1),new Item(2, 6),new Item(3, 10),new Item(5, 16)};
		int[] dp = new int[items.length];
		System.out.println(knapSackU(items, 6, 0,dp));
		System.out.println(kanpsackI(items, 7, 0));
	}

	public static int knapSackU(Item[] items,int maxW,int index,int[] dp){
		if(maxW==0 || index==items.length) return 0;
		//int maxValue = Integer.MIN_VALUE;
		if(dp[index]>0)
			return dp[index];

		if(maxW-items[index].weight<0)
			dp[index] =  knapSackU(items, maxW, index+1,dp);

		if(dp[index]>0)
			dp[index] = Math.max(knapSackU(items, maxW-items[index].weight, index+1,dp)+items[index].value, knapSackU(items, maxW, index+1,dp));

		return dp[index];
	}
	
	
	private static int kanpsackI(Item[] items,int maxW,int index){
		int[] cache = new int[maxW+1];
		
		for(Item item:items){
			int[] newCache = new int[maxW+1];
			
			for(int i=0;i<=maxW;i++){
				if(i<item.weight){
					newCache[i] = cache[i];
				}
				else{
					newCache[i] = Math.max(newCache[i-item.weight]+item.value, newCache[i]);
				}
			}
			
			cache = newCache;
		}
		
		
		
		
		return cache[maxW];
	}
	
	

	private int knapsack(Item[] items, int W, int
			i, Map<Integer, Map<Integer, Integer>> cache)
	{
		if (i == items.length) return 0;
		// Check if the value is in the cache
		if (!cache.containsKey(i))
			cache.put(i,new HashMap<Integer,Integer>());
		Integer cached = cache.get(i).get(W);
		if (cached != null) return cached;
		// Compute the item and add it to the cache
		int toReturn;
		if (W - items[i].weight < 0) {
			toReturn = knapsack(items, W, i+1, cache);
		} else {
			toReturn =
					Math.max(knapsack(items,
							W - items[i].weight,
							i+1, cache)
							+ items[i].value,
							knapsack(items, W, i+1, cache));
		}
		cache.get(i).put(W, toReturn);
		return toReturn;
	}


	public static int kanpSack(Item[] items,int maxW,int index){
		if(maxW==0) return 0;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; i < items.length; i++) {
			if(i!=index && maxW-items[i].weight>=0){
				int curVal = kanpSack(items, maxW-items[i].weight, index+1) + items[i].value;
				if(curVal>maxValue)
					maxValue = curVal;
			}
		}
		return maxValue;
	}

}

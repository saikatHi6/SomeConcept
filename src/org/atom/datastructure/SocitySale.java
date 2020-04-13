package org.atom.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class SocitySale {

	private final  static String TOP = "top";
	
	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++){
			
			int item = sc.nextInt();
			Map<String, Integer> sellItem = new HashMap<String, Integer>();
			
			for (int j = 0; j < item; j++) {
				
				String itemType = sc.next();
				
				
				if(!TOP.equals(itemType)){
					//String[] inputItem = itemType.split(" ");
					String itemName = itemType;
					int soldCount = sc.nextInt();
					if(!sellItem.containsKey(itemName)){
						sellItem.put(itemName, soldCount);
					}
					else{
						sellItem.put(itemName, sellItem.get(itemName)+soldCount);
					}
				}
				else{
					Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
			            
			            @Override
			            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
			                int v1 = e1.getValue();
			                int v2 = e2.getValue();
			                
			                if(v2==v1){
			                	return e1.getKey().compareTo(e2.getKey());
			                }
			                
			                
			                return v2-v1;
			            }
			        };
			        Set<Entry<String, Integer>> entries = sellItem.entrySet();
			        List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
			        
			        // sorting HashMap by values using comparator
			        Collections.sort(listOfEntries, valueComparator);
			        String maxItem = listOfEntries.get(0).getKey();
			        int maxValue = listOfEntries.get(0).getValue();
			        System.out.println(maxItem);
			        for(int k=1;k<listOfEntries.size() && listOfEntries.get(k).getValue()==maxValue;k++){
			        	
			        	System.out.println(listOfEntries.get(k).getKey());
			        	
			        }
			        
			        
			        
				}
				
				
			}
			
			
		}
		
		
		
		
	}

}

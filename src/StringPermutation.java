import java.io.BufferedInputStream;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet<>(); 
		 PriorityQueue<Integer> maxHeap;
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("AB");
		list.add("BC");
		list.add("CD");
		list.add("EF");
		list.add("GG");
		   for (String r : list) {
		      if (r.equals("BC")) {
		         list.remove(r);
		      }
		   }
		
		   BufferedInputStream    br;
		
		   LineNumberInputStream li;
		System.out.println(findPermutation("oidbcaf", "abc"));
	}
	
	public static boolean findPermutation(String str, String pattern) {
	    // TODO: Write your code here
	    Map<Character,Integer> map = new HashMap<Character, Integer>();
	    boolean flag = false;
	    
	    for (Character read : pattern.toCharArray()) {
			if(map.containsKey(read)){
				map.put(read, map.get(read)+1);
			}
			else{
				map.put(read, 1);
			}
		}
	    
	    for(int start=0;start<str.length();start++){
	    	Map<Character,Integer> copyMap = new HashMap<Character, Integer>(map);
	    	while(start<str.length() && !copyMap.isEmpty() &&copyMap.containsKey(str.charAt(start)) ){
	    		if(copyMap.get(str.charAt(start))>1)
	    			copyMap.put(str.charAt(start), copyMap.get(str.charAt(start))-1);
	    		else
	    			copyMap.remove(str.charAt(start));
	    		start++;
	    	}
	    	if(copyMap.isEmpty())
	    		flag = true;
	    			
	    	
	    }
	    
	    
	    

	    return flag;
	 }

}

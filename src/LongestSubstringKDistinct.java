import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbebi";
		System.out.println(findLength(s, 3));
	}
	
	public static int findLength(String str, int k) {
	    // TODO: Write your code here
	    int longSeq = 0;
	    int count = 0;
	    int windowStart = 0;
	    Map<Character,Integer> map = new HashMap<>();
	    for(int windoEnd=0;windoEnd<str.length();windoEnd++){
	        if(!map.containsKey(windoEnd)){
	            map.put(str.charAt(windoEnd),1);
	        }
	        else{
	            map.put(str.charAt(windoEnd),map.get(windoEnd)+1);
	        }
	        while(map.size()>k){
	        	if(map.containsKey(str.charAt(windowStart))){
	            if(map.get(str.charAt(windowStart))>1)
	                map.put(str.charAt(windowStart),map.get(windowStart)-1);
	            else
	                map.remove(str.charAt(windowStart)); 
	        	}
	            windowStart++;       
	        }
	        count =windoEnd - windowStart+1;
	        if(longSeq<count)
	          longSeq = count; 
	    }
	    return longSeq;
	  }

}

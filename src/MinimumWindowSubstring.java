import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubstring("abdacca", "abc"));
	}

	
	 public static String findSubstring(String str, String pattern) {
		    // TODO: Write your code here
		    int start = 0;
		    int patCount =0;
		    Map<Character,Integer> map = new HashMap<>();
		    for(int i=0;i<pattern.length();i++){
		        if(map.containsKey(pattern.charAt(i))){
		          map.put(pattern.charAt(i),map.get(pattern.charAt(i))+1);
		        }
		        else{
		          map.put(pattern.charAt(i),1);
		        }
		    }
		    for(int end=0;end<str.length();end++){
		        char cur = str.charAt(end);
		        if(map.containsKey(cur) && map.get(cur)>=1){
		          map.put(cur,map.get(cur)-1);
		          patCount++;
		        }
		        else if(map.containsKey(cur) && map.get(cur)==0){
		        	start++;
		        	while(!map.containsKey(str.charAt(start))){
		        		start++;
		        	}
		        }
		        if(patCount==pattern.length())
		          return str.substring(start,end+1);  

		    }


		    return "";
		  }
}

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgo1 {

	
	public static Map<Character, Integer> BAD_MATCH_TABLE = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] txt = "AABAACAADAABAABA".toCharArray();
		char[] pat = "AABA".toCharArray();
		
		badMatch(pat);
		int n= txt.length;
		int m = pat.length;
		
		
		int s = 0;
		
		while(s<=(n-m)){
			int j = pat.length-1;
			while(j>=0 && pat[j]==txt[s+j] )
				j--;
			
			if(j<0){
				System.out.println("Match at: "+s);
				s+= m;
			}
			else{
				if(BAD_MATCH_TABLE.containsKey(txt[s+j])){
					s+= BAD_MATCH_TABLE.get(txt[s+j]);
				}
				else{
					s+= pat.length;
				}
			}
			
			
		}
		
		
		
		
	}
	
	private static void badMatch(char[] pat){
		BAD_MATCH_TABLE.put('*', pat.length);
		for (int i = 0; i < pat.length; i++) {
			BAD_MATCH_TABLE.put(pat[i], Math.max(1, pat.length-i-1));
		}
	}
	
	

}

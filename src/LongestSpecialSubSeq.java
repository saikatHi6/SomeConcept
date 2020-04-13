import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSpecialSubSeq {

	public static void main(String[] args) {

		String s = "afcbedg";
		System.out.println(longSeq(s, s.length(), 2));
	}

	public static int longSeq(char[] ch,int n,int k){

		int[] dp = new int[n];

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if(ch[i]==ch[j]+k || ch[i]==ch[j]-k){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}

			}
		}

		int result = dp[0];
		for (int i = 0; i < dp.length; i++) {
			if(result<dp[i]){
				result = dp[i];
			}
		}
		return result;
	}

	public static int longSeq(String str,int n,int k){
		
		int[] dp = new int[n];
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int result = dp[0];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		map.put((int)str.charAt(0)-'a',0);
		
		for (int i = 1; i < n; i++) {
			int start = (str.charAt(i)-'a'-k);
			int end = (str.charAt(i)-'a'+k);
			
			if(start<0)
			    start = 0;
			if(end>25)
			    end = 25;
			    
			while(start<=end){
			    if(map.get(start)!=null){
			        int val = map.get(start);
			        dp[i] = Math.max(dp[i],dp[val]+1);
			    }
			    start = start+1;
			}    
			map.put((int)str.charAt(i)-'a',i);
			result = Math.max(dp[i],result);
		}
		return result;
	
	}

}

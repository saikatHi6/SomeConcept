package org.atom.dp.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BreakWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"};
		List<String> words = Arrays.asList(arr);
		/*words.add("a");
		words.add("bb");
		words.add("bbb");
		words.add("bbbb");*/
		String s = "bccdbacdbdacddabbaaaadababadad";
		System.out.println(wordBreak(s, words));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
	       return wordBreak(s,wordDict,"");
	    }
	    
	    public static boolean wordBreak(String s, List<String> wordDict,String t) {
	        if(s.length()==t.length()){
	            return s.equals(t);
	        }
	        
	        for(String w:wordDict){
	            if(s.length()>t.length() && wordBreak(s,wordDict,t.concat(w)) ){
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    
	    public static boolean wordBreak1(String s, List<String> wordDict) {
	       
	    	if(s.length()<=0) return true;
	    	
	    	for (String word : wordDict) {
				if(word.length()<=s.length() && word.equals(s.substring(0, word.length()))){
					if(wordBreak(s.substring(0, word.length()), wordDict))
						return true;
				}
					
				
			}
	    	
	    	
	    	
	        return false;
	    }


}

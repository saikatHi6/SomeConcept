package org.solve.amazon;

import java.util.StringTokenizer;

public class MinDistanceInScentance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("Amazon", "The", "Amazon is the best company to work for. The amazon is a beautiful forest."));
	}

	//Given an Amazon reviews paragraph containing several words, find the minimum distance between two given words.
		//Example: Following is a hypothetical paragraph in an amazon review –
		//“Amazon is the best company to work for. The amazon is a beautiful forest.”

		public static int minDistance(String s1, String s2, String sentence){
		   if(s1==null || s1.isEmpty() || s2==null || s2.isEmpty() || sentence==null || sentence.isEmpty())
		       return -1;
		       

		    int minD = Integer.MAX_VALUE;
		    int p1 = -1;
		    int p2 = -1;
		    
		    StringTokenizer st = new StringTokenizer(sentence);
		    int p = -1;
		    while(st.hasMoreTokens()){
		        String t = st.nextToken();
		        p++;
		        if(t.equals(s1))
		            p1 = p;
		        if(t.equals(s2))
		            p2 = p;
		        minD = minD > p2-p1? p2-p1:minD;    
		    }
		    
		    return minD;
		}
	
}

package org.atom.dp.recursion;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'A','B','C'};
		int[] freq = {2,1,1};
		permutation(str, freq, new char[4], 0);
	}
	
	
	public static void permutation(char[] str,int[] freq,char[] result,int level ){
		if(result.length==level){
			print(result);
			return;
		}
		for(int i=0;i<str.length;i++){
			if(freq[i]==0)
				continue;
			result[level] = str[i];
			freq[i]--;
			permutation(str, freq, result, level+1);
			freq[i]++;
		}
	}
	
	public static void print(char[] ch){
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
	}

}

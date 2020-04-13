
public class BoyerMooreAlgo {

	static int NO_OF_CHAR = 256;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] txt = "AABAACAADAABAABA".toCharArray();
		char[] pat = "AABA".toCharArray();
		search(pat, txt);
	}

	private static void search(char[] pat,char[] txt){
		int[] charCount = new int[NO_OF_CHAR];

		int m = pat.length;
		int n = txt.length; 

		badCharHuristic(pat, charCount);

		int s = 0;

		while(s<=(n-m)){
			int j =m-1;
			while(j>=0 && pat[j]==txt[s+j]){
				j--;
			}

			if(j<0){
				System.out.println(s);
				s += (s+m < n)? m-charCount[txt[s+m]] : 1; 
			}
			else{
				 s += max(1, j - charCount[txt[s+j]]); 
			}
		}



	}
	
	static int max (int a, int b) { return (a > b)? a: b; } 

	private static void  badCharHuristic(char[] txt,int[] charCount){

		for (int i = 0; i < charCount.length; i++) {
			charCount[i] = -1;
		}

		for (int i = 0; i < txt.length; i++) {
			charCount[(int)txt[i]] = i;
		}


	}

}

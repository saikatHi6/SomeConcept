import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="catcatfoxfox"; String[] words={"cat", "fox"};
		System.out.println(findWordConcatenation(str, words));
	}
	

	  public static List<Integer> findWordConcatenation(String str, String[] words) {
	    List<Integer> resultIndices = new ArrayList<Integer>();
	    int windowWordStart = 0;
	    int winStart = 0;
	    int wordSize = words[0].length();
	    Map<String,Integer> map = new HashMap<>();
	    for(int winEnd=0;winEnd<str.length();winEnd++){
	        if(wordSize==winEnd-winStart+1){
	          String pWord = str.substring(winStart,winEnd+1);
	          //System.out.println(pWord);
	          map.put(pWord,winStart);
	          winStart = winEnd+1;
	          if(map.size()==words.length){
	            String subKey = str.substring(windowWordStart,windowWordStart+wordSize);
	            System.out.println(subKey);
	            resultIndices.add(map.get(subKey));
	            windowWordStart = map.get(subKey)+wordSize;
	            map.remove(subKey);
	            
	          }
	        }
	    }

	    // TODO: Write your code here
	    return resultIndices;
	  }

}

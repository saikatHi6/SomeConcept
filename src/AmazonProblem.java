import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

// "static void main" must be defined in a public class.
public class AmazonProblem {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        int numCompetitors = 6;
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        int numReviews = 6;
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "i am proud to have fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery afshion"};

        /*
        intuition: Top N frequently used words
        - store the competitors into map, along with their frequent count
        - loop through reviews
            - convert the review to lowercase, and split by space
            - if a word is not a competitor then avoid
            - if a word is being used already for a review then avoid
            - else increase the count of the competitor
        - Create a PriorityQueue to find the N top elements, and provided logic to sort
        - Create an array, and fill up with the N top elements
        */
                
        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);
        
        System.out.println(result);
    }
    
    
    public static List<String> getTopCompetitors(int numCompetitors, int topNCompetitors
                                                 , String[] competitors, int numReviews, String[] reviews) {
    	
    	List<String> top2Compitators = new ArrayList<String>();
    	
    	
    	PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> ( a.getValue() == b.getValue() 
                ? b.getKey().compareTo(a.getKey())
                : a.getValue() - b.getValue() ));
    	
    	Map<String, Integer> competor = new HashMap<>();
    	for (int i = 0; i < competitors.length; i++) {
			competor.put(competitors[i], 0);
		}
    	
    	for (int i = 0; i < reviews.length; i++) {
			String[] eachSentance = reviews[i].split(" ");
			for (int j = 0; j < eachSentance.length; j++) {
				if(competor.containsKey(eachSentance[j])){
					competor.put(eachSentance[j], competor.get(eachSentance[j])+1);
				}
			}
		}
    	
    	List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(competor.entrySet());
    	
    	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				if(o2.getValue().compareTo(o1.getValue())==0)
					return o1.getKey().compareTo(o2.getKey());
				
				return o2.getValue().compareTo(o1.getValue());
			}
		});
    	
    	int co = 0;
    	
    	for (Entry<String, Integer> entry : list) {
    		if(co==2){
    			break;
    		}
    		top2Compitators.add(entry.getKey());
    		co++;
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return top2Compitators;
    	
    	
    	
    }
}
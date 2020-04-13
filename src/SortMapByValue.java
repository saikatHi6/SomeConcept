import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortMapByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> codenames = new HashMap<String, String>();
		codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("Java SE 7", "Dolphin");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        
        
        
        TreeMap<String, String> sortedByKey = new TreeMap<>(codenames);
        Set<Map.Entry<String, String>> set = sortedByKey.entrySet();
        
        for(Map.Entry<String, String> each:set){
        	System.out.println(each.getKey()+" : "+each.getValue());
        }
        
        //Map.Entry.
        //codenames.entrySet() .stream() .sorted(comparingByValue()) .collect( toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        
        System.out.println("==============================");
        
        List<Map.Entry<String, String>> list = new LinkedList<>(codenames.entrySet());
        
        Comparator<Map.Entry<String, String>> compare = new Comparator<Map.Entry<String,String>>() {
        	
        	public int compare(Map.Entry<String, String> m1,Map.Entry<String, String> m2){
        		return m2.getValue().compareTo(m1.getValue());
        	}
        	
		};
		
		
		Collections.sort(list,compare);
		
		
		HashMap<String, String> finalMap = new LinkedHashMap<String, String>();
		
		for(Map.Entry<String, String> each:list){
			finalMap.put(each.getKey(), each.getValue());
		}
        
		for(Map.Entry<String, String> each:finalMap.entrySet()){
        	System.out.println(each.getKey()+" : "+each.getValue());
        }
		
		

	}

}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class parent implements Comparable<parent>{
	
	int id;
	String name;
	
	Comparator<String> cs = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	protected String display(String s){
		
		if(s.length()==0)
			return s;
		return s.charAt(s.length()-1)+display(s.substring(0, s.length()-1));
		
	}
	
	protected void display(Object s){
		System.out.println(s);
	}

	@Override
	public int compareTo(parent o) {
		// TODO Auto-generated method stub
		return 0;
	}
}




public class NextClosetTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		parent p = new parent();
		System.out.println(p.display("ABC"));
		 Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        for (int n = 0; n < t; n++) {
	        	String inputTime =sc.next(); 
	            String[] times = inputTime.split(":");
	            int secI = Integer.parseInt(times[2]);
	            int minI = Integer.parseInt(times[1]);
	            int houI = Integer.parseInt(times[0]);
	            
	            if(secI>59 || minI>59 || houI>24){
	            	System.out.println("INVALID");
	            	continue;
	            }
	                       
	           StringBuffer secR = new StringBuffer(times[2]);
	            secR.reverse();
	            StringBuffer minR = new StringBuffer(times[1]);
	            minR.reverse();
	            StringBuffer houR = new StringBuffer(times[0]);
	            houR.reverse();
	            
	            if(secI==minI && minI==houI && Integer.parseInt(secR.toString())<59){
	            	System.out.println(houI+":"+minI+":"+secR);
	            	continue;
	            }
	            /*
	            if()
	            if(Integer.parseInt(s))*/
	            
	            System.out.println(nextClosestTime(inputTime));
	            
	            
	            
	      }
		
		
	}
	
	public static String nextClosestTime(String time) {
	    ArrayList<Integer> list = new ArrayList<>();
	    ArrayList<Character> charList = new ArrayList<>();
	    TreeSet<Integer> set = new TreeSet<>();
	 
	    //get digit list
	    for (int i = 0; i < time.length(); i++) {
	        if (time.charAt(i) >= '0' && time.charAt(i) <= '9') {
	            charList.add(time.charAt(i));
	        }
	    }
	 
	    //get all possible number combinations
	    for (int i = 0; i < charList.size(); i++) {
	        for (int j = 0; j < charList.size(); j++) {
	        	if(charList.get(i)!=charList.get(j))
	        		set.add(Integer.parseInt(charList.get(i) + "" + charList.get(j)));
	        }
	    }
	 
	    //add to list
	    list.addAll(set);
	 
	    String[] arr = time.split(":");
	    int hour = Integer.parseInt(arr[0]);
	    int min = Integer.parseInt(arr[1]);
	    int sec = Integer.parseInt(arr[2]);
	 
	    int idxMin = search(list, min);
	    int idxHour = search(list, hour);
	    int idSec = search(list, sec);
	 
	    String hh = "";
	    String mm = "";
	    String ss = "";
	    
	    
	    String reArTime = "";
	    
	    if(list.get(idxHour)<24){
	    	hh = hh + list.get(idxHour);
	    }
	    if(list.get(idxMin)<60){
	    	if(isExist(hh, list.get(idxMin+1))){
	    		mm = mm+list.get(idxMin+1);
	    	}
	    	else if(isExist(hh, list.get(idxMin-1))){
	    		mm = mm+list.get(idxMin-1);
	    	}
	    }
	    if(list.get(idSec)<60){
	    	if(isExist(hh+mm, list.get(idSec+1))){
	    		ss = ss+list.get(idSec+1);
	    	}
	    	else if(isExist(hh+mm, list.get(idSec-1))){
	    		ss = ss+list.get(idSec-1);
	    	}
	    }
	    
	    
	 
	    /*if(idSec<list.size()-1 && list.get(idSec+1)<60){
	    	int secVal = list.get(idSec+1);
	    	if(!isExist(time, secVal))
	    		secVal = list.get(idSec-1);
	    	
	    }
	    if (idxMin < list.size() - 1 && list.get(idxMin + 1) < 60) {
	        hh = hour + "";
	        mm = list.get(idxMin + 1) + "";
	    } else {
	        if (idxHour < list.size() - 1 && list.get(idxHour + 1) < 24) {
	            hh = list.get(idxHour + 1) + "";
	            mm = list.get(0) + "";
	        } else {
	            hh = list.get(0) + "";
	            mm = list.get(0) + "";
	        }
	    }*/
	 
	    if (hh.length() < 2) {
	        hh = "0" + hh;
	    }
	 
	    if (mm.length() < 2) {
	        mm = "0" + mm;
	    }
	    
	    if (ss.length() < 2) {
	        ss = "0" + ss;
	    }
	 
	    return hh + ":" + mm + ":" + ss;
	}
	
	private static boolean isExist(String input,int dig){
		
		while(dig!=0){
			int mod = dig/10;
			char c=(char)mod;
			for(int i=0;i<input.length();i++){
				if(input.charAt(i)==c+'0')
					return false;
			}
			/*if(input.indexOf(c)>-1)
				return false;*/
			dig = dig/10;
		}
			
		return true;
	}
	 
	private static int search(ArrayList<Integer> list, int target) {
	    int i = 0;
	    int j = list.size() - 1;
	 
	    while (i < j) {
	        int m = i + (j - i) / 2;
	        if (list.get(m) < target) {
	            i = m + 1;
	        } else {
	            j = m;
	        }
	    }
	 
	    return j;
	}
	

}

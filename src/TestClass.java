import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         long[] arr = new long[n];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Long.parseLong(arr_arr[i_arr]);
         }

         long out_ = Solution(arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static long Solution(long[] arr){
        // Write your code here
        // Hash Map to store prefix XOR values 
        
    int MAX = 10;    
    HashMap<Integer, 
            Integer> mp = new HashMap<Integer, 
                                      Integer>(); 
  
    // When no element is selected 
    mp.put(0, 1); 
  
    int answer = 0; 
    int preXor = 0; 
    for (int i = 0; i < arr.length; i++)  
    { 
        int value = 1; 
        preXor^= arr[i]; 
  
        // Check for all the powers of 2,  
        // till a MAX value 
        for (int j = 1; j <= arr.length; j++)  
        { 
            int Y = value ^ preXor; 
            if (mp.containsKey(Y))  
            { 
                answer+= mp.get(Y); 
            } 
            value*= 2; 
        } 
  
        // Insert Current prefixxor in Hash Map 
        if (mp.containsKey(preXor))  
        { 
            mp.put(preXor,mp.get(preXor) + 1); 
        } 
        else 
        { 
            mp.put(preXor, 1); 
        } 
    } 
    return answer; 
    
    }
}
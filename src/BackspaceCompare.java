
public class BackspaceCompare {

  public static boolean compare(String str1, String str2) {
    // TODO: Write your code here
    int ptr1 = str1.length()-1;
    int ptr2 = str2.length()-1;

    while(ptr1!=-1 && ptr2!=-1){
      if(str1.charAt(ptr1)!='#' && str1.charAt(ptr1)==str2.charAt(ptr2)){
        ptr1--;
        ptr2--;
      }
      else if(str1.charAt(ptr1)=='#'){
        int countHash = 0;
        while(str1.charAt(ptr1)=='#'){
          countHash++;
          ptr1--;
        }
        ptr1-= countHash;
      }
      else if(str2.charAt(ptr2)=='#'){
        int countHash = 0;
        while(str2.charAt(ptr2)=='#'){
          countHash++;
          ptr2--;
        }
        ptr2-= countHash;
      }
      else
        return false;
    }

    return true;
  }
  
  public static void main(String[] args){
	  System.out.println(compare("xp#", "xyz##"));
  }
  
  
}

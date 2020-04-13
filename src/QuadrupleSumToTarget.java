import java.util.*;

class QuadrupleSumToTarget {
	
  public static void main(String[] args){
	  int[] arr = {4, 1, 2, -1, 1, -3};
	  int target = 1;
	  System.out.println(searchQuadruplets(arr, target));
  }

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();
    // TODO: Write your code here
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++){
        search(quadruplets,target-arr[i],i+1,arr);
    }
    return quadruplets;
  }

  public static void search(List<List<Integer>> quadruplets,int target,int start,int[] arr){
      int end = arr.length-1;
      int sum = 0;
      int left = start;
      int right = end;
      while(start<end){
        sum+= arr[start]+arr[end];
        if(target==sum){
          sum = 0;
          List<Integer> sub = new ArrayList<>();
          while(left<=start){
            sub.add(arr[left++]);
          }
          while(right>=end){
            sub.add(arr[right--]);
          }
          quadruplets.add(sub);
          start++;
          end--;
        }
        else if(target>sum){
          start++;
        }
        else if(target<sum){
          end--;
        }

      }

  }


}
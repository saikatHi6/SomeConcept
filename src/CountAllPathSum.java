import java.util.*;



class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    // TODO: Write your code here

    return findPaths(root,S,0,S,0);
  }

  public static class Prev{
    int prevVal;
    Prev(int prevVal){
      this.prevVal = prevVal;
    }
  }
  public static int findPaths(TreeNode root,int sum,int count,int copySum,int prev){
      if(root==null)
          return 0;
      if(sum==root.val){
          count++;
          return count;
      }
      
      int lCount = findPaths(root.left,sum-root.val,count,copySum,root.val);
      int rCount = findPaths(root.right,sum-root.val,count,copySum,root.val);
       
      if(copySum==prev){
          count++;
          return count;
      }      
      return lCount+rCount;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}

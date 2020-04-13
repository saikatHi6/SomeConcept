import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    // TODO: Write your code here
    Collections.sort(new ArrayList<>());
    findPath(root,sum,allPaths,new ArrayList<>());
    return allPaths;
  }

  public static void findPath(TreeNode root,int sum,List<List<Integer>> allPaths,List<Integer> path){

      if(root==null)
          return ;
      //List<Integer> path = new ArrayList<>();
      path.add(root.val);
      if(root.val==sum && root.left==null && root.right==null){
    	allPaths.add(new ArrayList<>(path));
        path.remove(new Integer(root.val));
        return ;
      } 
      /*else if(root.left==null && root.right==null){
        
      }*/
    
    findPath(root.left,sum-root.val,allPaths,path);
    
    findPath(root.right,sum-root.val,allPaths,path);
    
    path.remove(new Integer(root.val));
    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(3);
    root.left.right.left = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {
    // TODO: Write your code here
	  if(root==null)
	        return false;
	  if(sum==root.val)
        return true;
   
    
    if(root.left!=null && hasPath(root.left,sum-root.val))
          return true;
    if(root.right!=null && hasPath(root.right,sum-root.val))
          return true;              

    return false;
  }
  
  public static int maxSum(TreeNode root,int sum){
	  if(root==null)
		  return sum;
	  
	  int lSum = maxSum(root.left, sum+root.val);
	  int rSum = maxSum(root.right, sum+root.val);
	  
	  return lSum>rSum?lSum:rSum;
	  
	  
  }
  

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(25);
    root.left.right.left = new TreeNode(30);
    root.left.right.right = new TreeNode(65);
    root.right.left = new TreeNode(50);
    root.right.right = new TreeNode(20);
    root.right.right.left = new TreeNode(60);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    System.out.println(maxSum(root, 0));
  }
}
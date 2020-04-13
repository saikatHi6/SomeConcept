package org.atom.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TNode{
	
	public TNode(int val) {
		this.val = val;
	}
	
	int val;
	TNode left;
	TNode right;

}

class BT_NoParentPtr_Solution1{

		List<Integer> listN1 = new ArrayList();
		List<Integer> listN2 = new ArrayList();
		private TNode root;

		int findLCA(int n1,int n2){
			listN1.clear();
			listN2.clear();
			return processLCA(root,n1,n2);
		
		}
		
		int processLCA(TNode root,int n1,int n2){
		
			if(!findPath(root,n1,listN1) || !findPath(root,n2,listN2)){
				System.out.println("Not Exist");
				return -1;
			}
			
			int i;
			for(i=0;i<listN1.size() && i<listN2.size(); i++){
			
				if(!listN1.get(i).equals(listN2.get(i)))
					break;
			}
			
			return listN1.get(i-1);
		
		}
		
		
		boolean findPath(TNode root,int n,List<Integer> list){
		
			if(root==null) return false;
			
			list.add(root.val);
			
			if(root.val==n) return true;
			
			if(root.left!=null && findPath(root.left,n,list)){
				return true;
			}
			
			if(root.right!=null && findPath(root.right,n,list)){
				return true;
			}
			
			list.remove(list.size()-1);
			
			return false;
		
		}
		
		public boolean pathFind(TNode root,int node1,List<Integer> list){

			if(root==null)
				return false;

			list.add(root.val);
			
			if(root.val==node1)
				return true;

			if(root.left!=null && pathFind(root.left, node1,list))
				return true;

			if(root.right!=null && pathFind(root.right, node1,list))
				return true;
			
			list.remove(list.size()-1);

			return false;

		}
		
		
		public void bfsPathFind(TNode root,int n){
			
			List<List<Integer>> path = new ArrayList<>();
			
			Queue<int[]> qu = new LinkedList<>();
			qu.add(new int[]{n,-1});
			
			
		}
		


		public static void main(String[] args) {
			BT_NoParentPtr_Solution1 tree = new BT_NoParentPtr_Solution1(); 
			tree.root = new TNode(1); 
			tree.root.left = new TNode(2); 
			tree.root.right = new TNode(3); 
			tree.root.left.left = new TNode(4); 
			tree.root.left.right = new TNode(5); 
			tree.root.right.left = new TNode(6); 
			tree.root.right.right = new TNode(7); 
			
			List<Integer> list = new ArrayList<>();
			tree.pathFind(tree.root, 6,list);

			list.forEach(System.out::print);
			
			/*System.out.println("LCA(4, 5): " + tree.findLCA(4,8)); 
			System.out.println("LCA(4, 6): " + tree.findLCA(4,6)); 
			System.out.println("LCA(3, 4): " + tree.findLCA(3,4)); 
			System.out.println("LCA(2, 4): " + tree.findLCA(2,4)); */
		}
		
}

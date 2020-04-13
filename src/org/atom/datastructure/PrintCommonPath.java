package org.atom.datastructure;

import java.util.ArrayList;
import java.util.List;

public class PrintCommonPath {

	
	
	public static void printCommonPath(TNode root,int n1,int n2){
		List<Integer> path1List = new ArrayList();
		List<Integer> path2List = new ArrayList();
		
		if(!findPath(root, n1, path1List) || !findPath(root, n2, path2List)){
			System.out.println("Not exist");
		}
		
		for(int i=0;i<path1List.size() && i<path2List.size();i++){
			
			if(path1List.get(i).equals(path2List.get(i)))
				System.out.println(" "+path1List.get(i));
			else
				break;
			
		}
			
		
	}
	
	public static boolean findPath(TNode root,int n1,List<Integer> path1List){
		
		if(root==null)
			return false;
		
		path1List.add(root.val);
		
		if(root.val==n1)
			return true;
		
		if(root.left!=null && findPath(root.left, n1, path1List))
			return true;
		
		if(root.left!=null && findPath(root.right, n1, path1List))
			return true;
		
		path1List.remove(path1List.size()-1);
		
		return false;
		
	}
	
	public static TNode lca(TNode root,int n1,int n2){
		
		if(root==null)
			return null;
		
		if(root.val==n1 || root.val==n2)
			return root;
		
		TNode leftNode = lca(root.left,n1,n2);
		TNode rightNode = lca(root.right,n1,n2);
		
		if(leftNode!=null && rightNode!=null)
			return root;
		
		return (leftNode!=null)?leftNode:rightNode;
		
		
	}
	
	public static boolean printAncestor(TNode root,int target){
		
		if(root==null)return false;
		
		if(root.val==target){
			System.out.println(root.val);
			return true;
		}
		
		if(printAncestor(root.left, target)|| printAncestor(root.right, target)){
			System.out.println(root.val);
			return true;
		}
		return false;
	}
	
	public static boolean findCommonPath(TNode node,int n1,int n2){
		if(node==null) return false;
		
		TNode LCA = lca(node, n1, n2);
		
		if(LCA==null)return false;
		
		printAncestor(node,LCA.val);

		return true;
	}
	
	
	public static void main(String[] args) {

		TNode root = new TNode(1); 
		root.left = new TNode(2); 
		root.right = new TNode(3); 
		root.left.left = new TNode(4); 
		root.left.right = new TNode(5); 
		root.right.left = new TNode(6); 
		root.right.right = new TNode(7); 
		root.left.right.left = new TNode(8); 
		root.right.left.right = new TNode(9); 
			
		int n1 = 9, n2 = 7; 
		findCommonPath(root, n1, n2);
	}

}

package org.atom.datastructure;

public class PathFinder {


	public boolean pathFind(TNode root,int node1){

		if(root==null)
			return false;

		if(root.val==node1)
			return true;

		if(pathFind(root.left, node1))
			System.out.println(root.val);

		if(pathFind(root.right, node1))
			System.out.println(root.val);

		return false;

	}


}

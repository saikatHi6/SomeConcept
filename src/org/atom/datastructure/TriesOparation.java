package org.atom.datastructure;

import java.util.Collections;

public class TriesOparation {
	
	private TriesNode root;
	
	public TriesOparation() {
		root = new TriesNode();
	}
	
	public void insert(String word){
		TriesNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(!node.containKey(ch)){
				node.put(ch, new TriesNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}
	
	public boolean search(String word){
		if(word==null)
			return false;
		char[] ltr = word.toCharArray();
		return search(ltr, 0, root);
	}
	
	public boolean search(char[] ltr,int pos,TriesNode node){
		if(node==null)
			return false;
		if(pos==ltr.length)
			return node.isEnd();
		char ch = ltr[pos];
		if(ch!='.')
			return search(ltr, pos+1, node.get(ch));
		for(char a='a';a<='z';a++){
			if(search(ltr, pos+1, node.get(a)))
				return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriesOparation triesOparation = new TriesOparation();
		triesOparation.insert("bad");
		triesOparation.insert("dad");
		triesOparation.insert("mad");
		System.out.println(triesOparation.search("pad"));
		System.out.println(triesOparation.search("bad"));
		System.out.println(triesOparation.search(".ad"));
		System.out.println(triesOparation.search("b.."));
		
		
	}

}

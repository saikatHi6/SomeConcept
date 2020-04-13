package org.atom.datastructure;

public class TriesNode {
	
	private TriesNode[] tries;
	private final int R = 26;
	private boolean isEnd;
	
	public TriesNode() {
		tries = new TriesNode[R];
	}
	
	public void put(char ch,TriesNode triesNode){
		tries[ch-'a'] = triesNode;
	}
	
	public boolean containKey(char ch){
		return tries[ch-'a']!=null;
	}
	
	public TriesNode get(char ch){
		return tries[ch-'a'];
	}
	
	public void setEnd(){
		isEnd = true;
	}
	
	public boolean isEnd(){
		return isEnd;
	}

}

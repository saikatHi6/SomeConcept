package com.morgan.version;

import java.util.HashMap;
import java.util.Map;

public class VersionMapImpl<K extends Comparable<K>,V> implements VersionMap<K, V> {
	
	
	private int size;
	private int capacity;
	private int currentVersion;
	
	private Map<Integer, Map<K,V>> versionControl;
	private Map<K,V> myDataStore;
	
	private Node<K, V> node;
	

	public VersionMapImpl() {
		this.capacity = 0;
		this.currentVersion = 1;
		myDataStore = new HashMap<>();
		versionControl = new HashMap<>();
	}

	@Override
	public void put(K Key, V value) throws RuntimeException {
		// TODO Auto-generated method stub
		
		if(this.capacity==0)
			return ;
		
		if(this.size==this.capacity){
			Comparable<K> leastEle = new Comparable<K>() {

				@Override
				public int compareTo(K arg0) {
					return arg0.compareTo(Key);
				}
			};
			
			myDataStore.remove(leastEle);
			this.size--;
		}
		
		if(this.capacity!=0){
			myDataStore.put(Key, value);
			this.size++;
		}
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return myDataStore.get(key);
	}

	@Override
	public Boolean snapshot() {
		// TODO Auto-generated method stub
		
		versionControl.put(currentVersion, this.myDataStore);
		this.myDataStore = new HashMap<>();
		currentVersion++;
		
		return true;
	}

	@Override
	public V getValVersion(int version_id, K key) {
		// TODO Auto-generated method stub
		
		if(versionControl.containsKey(version_id)){
			Map<K,V> ver = versionControl.get(version_id);
			return ver.get(key);
		}
		
		return null;
	}

	@Override
	public void setMaxSize(int size_) {
		// TODO Auto-generated method stub
		this.capacity = size_;
	}

}

package com.morgan.version;

public interface VersionMap<K extends Comparable<K>,V> {

	void put(K Key, V value) throws RuntimeException;
	
	V get(K key);
	
	Boolean snapshot();
	
	V getValVersion(int version_id,K key);
	
	void setMaxSize(int size_);
	
	
}

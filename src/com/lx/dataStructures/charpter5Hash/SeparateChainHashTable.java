package com.lx.dataStructures.charpter5Hash;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainHashTable<AnyType> {
	
	private static final int DEFAULT_SIZE = 101;
	
	private List<AnyType> []  lists;
	
	private int currentSize;
 
	public SeparateChainHashTable() {
		this(DEFAULT_SIZE);
	}

	public  SeparateChainHashTable(int size) {
		lists = new LinkedList[nextPrime(size)];//使表的大小为素数
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<AnyType>();
		}
	}

	public void insert(AnyType e) {
		int idx = myhash(e);
		if(!lists[idx].contains(e)){
			lists[idx].add(e);
			if(++currentSize>lists.length)
				rehash();
		}
	}

	public void remove(AnyType e) {
		if(lists[myhash(e)].contains(e)){
			lists[myhash(e)].remove(e);
			currentSize--;
		}
	}

	public boolean contain(AnyType e) {
		return lists[myhash(e)].contains(e);
	}

	public void makeEmpty(){
		for (int i = 0; i < lists.length; i++) {
			lists[i].clear();
		}
		currentSize = 0;
	}
	
	private void rehash(){
		
	}
	
	private int myhash(AnyType e){
		int hashVal = e.hashCode();
		hashVal %= lists.length;
		if(hashVal<0){
			hashVal+=lists.length;
		}
		return hashVal;
	}
	
	private static int nextPrime(int n){
		return n;
	}
	
	private static boolean isPrime(int n){
		return false;
	}
}

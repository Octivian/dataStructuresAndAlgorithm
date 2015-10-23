package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Iterator;

import com.lx.dataStructures.charpter3ListStackQueue.lsq.MyArrayList;

public class MyArrayListWithAddAll9 extends MyArrayList{
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * O(N)
	 * @param items
	 * @return
	 */
	public MyArrayList addAll(Iterable<? extends Object> items){
		Iterator<? extends Object> it = items.iterator();
		while(it.hasNext()){
			super.add(it.next());
		}
		return this;
	}
}

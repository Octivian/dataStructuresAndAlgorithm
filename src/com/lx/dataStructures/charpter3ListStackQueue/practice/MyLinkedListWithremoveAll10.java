package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Iterator;

import com.lx.dataStructures.charpter3ListStackQueue.MyLinkedList;

public class MyLinkedListWithremoveAll10 extends MyLinkedList{
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * O(N^2)
	 * @param items
	 * @return
	 */
	public MyLinkedList removeAll(Iterable<? extends Object> items){
		Iterator<? extends Object> it1 = items.iterator();
		while(it1.hasNext()){
			Object o1 = it1.next();
			Iterator<? extends Object> it2= iterator();
			while(it2.hasNext()){
				if(o1.equals(it2.next())){
					it2.remove();
				}
			}
		}
		return this;
	}
}

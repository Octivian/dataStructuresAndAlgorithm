package com.lx.dataStructures.charpter3ListStackQueue.practice;

import com.lx.dataStructures.charpter3ListStackQueue.lsq.MyLinkedList;

public class MyLinkedListWithContain3 extends MyLinkedList {
	
	public boolean contain(Object o){
		Node<Object> p = beginMarker;
		while(p!=endMarker){
			p=p.next;
			if(p.data.equals(o))
				return true;
		}
		return false;
	}
}

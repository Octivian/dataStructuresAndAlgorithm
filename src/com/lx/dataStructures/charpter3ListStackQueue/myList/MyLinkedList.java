package com.lx.dataStructures.charpter3ListStackQueue.myList;


/**
 * 1.包含两端的链，表的大小以及一些方法
 * 2.Node类，私有嵌套类。此类中包含数据本身以及到前一个Node的链和到下一个Node的链
 * 3.LinedListIterator类，抽象了位置的概念，是一个私有类，实现接口Iterator，next，hasNext，remove
 * @author lx
 *
 */
public class MyLinkedList {
	private int size;
	private int modCount;
	private Node<Object> beginMarker;
	private Node<Object> endMarker;
	
	
	public MyLinkedList() {
		clear();
	}
	
	public void clear(){
		beginMarker = new Node<Object>(null, null, null);
		endMarker = new Node<Object>(null, null, null);
		beginMarker.next = endMarker;
		size = 0;
		modCount++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	private void addBefore(Node<Object> p,Object x){
		
	} 
	
	private static class Node<Object>{
		public Object data;
		public Node<Object> prev;
		public Node<Object> next;
		public Node(Object x,Node<Object> previous,Node<Object> n) {
			data = x;
			prev = previous;
			next = n;
		}
	}
}

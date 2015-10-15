package com.lx.dataStructures.charpter3ListStackQueue.myList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


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
	
	public void add(Object x){
		addBefore(getNode(size()), x);
	}
	
	public void add(int idx,Object x){
		addBefore(getNode(idx), x);
	}
	public Object get(int idx){
		return getNode(idx).data;
	}
	
	public Object set(int idx,Object x){
		Node<Object> currentNode = getNode(idx);
		Object oldX = currentNode.data;
		currentNode.data = x;
		return oldX;
	}
	
	public Object remove(int idx){
		return remove(getNode(idx));
	}
	
	private Object remove(Node<Object> n){
		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;
		modCount++;
		return n.data;  
	}
	
	private Node<Object> getNode(int idx){
		if(idx > size||idx<0){
			throw new IndexOutOfBoundsException();
		}
		Node<Object> n;
		if(idx < size()/2){
			n = beginMarker.next;
			for(int i = 0;i<idx;i++){
				n = n.next;
			}
		}else{
			n = endMarker;
			for(int i = size();i>idx;i--){
				n=n.prev;
			}
		}
		return n;
	}
	
	private void addBefore(Node<Object> n,Object x){
		Node<Object> node = new Node<Object>(x,n.prev,n);
		n.prev = node;
		node.prev.next = node;
		size++;
		modCount++;
	}
	
	private static class Node<Object>{
		public Object data;
		public Node<Object> prev;
		public Node<Object> next;
		public Node(Object x,Node<Object> p,Node<Object> n) {
			data = x;
			prev = p;
			next = n;
		}
	}
	
	public Iterator<Object> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Object>{

		private  Node<Object> current = beginMarker;
		private  int expectedModCount = modCount;
		private  boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current!=endMarker;
		}

		@Override
		public Object next() {
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			current = current.next;
			okToRemove = true;
			return current.data;
		}

		@Override
		public void remove() {
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
		
	}
}

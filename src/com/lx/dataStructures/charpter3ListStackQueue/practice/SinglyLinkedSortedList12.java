package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Comparator;



public class SinglyLinkedSortedList12<E> {
	
	public static void main(String[] args) {
		SinglyLinkedSortedList12<Integer> slist = new SinglyLinkedSortedList12<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		slist.add(1);
		slist.add(1);
		slist.add(2);
		slist.add(1);
		slist.add(1);
		slist.remove(1);
		System.out.println(slist.toString());
	}
	
	private Comparator<E> comparator;
	private int size;
	private int modCount;
	Node<E> beginMarker;
	
	public SinglyLinkedSortedList12(Comparator<E> comparator){
		this.comparator = comparator;
		size = 0;
		modCount++;
		beginMarker = new Node<E>(null,null);
	}
	
	public int size(){
		return size;
	}
	
	private static class Node<E>{
		E item;
        Node<E> next;
        public Node(Node<E> next,E x) {
        	item = x;
        	this.next = next;
		}
	}
	
	public void add(E x){
		if(size == 0){
			Node<E> node = new Node<E>(null, x);
			beginMarker.next = node;
		}else{
			int count = size;
			int mid = count>>1;
			while(mid!=0){
				if(comparator.compare(getNode(mid).item, x)<0){
					mid = mid>>1;
				}else{
					mid = mid+(mid>>1);
				}
			}
		}
		add(size,x);
	}
	
	public void add(int idx,E x){
		if(idx == 0){
			addAfter(beginMarker,x);
		}else{
			addAfter(getNode(idx-1),x);
		}
	}
	
	public E get(int idx){
		return getNode(idx).item;
	}
	
	private  Node<E> getNode(int idx){
		if(idx>size-1||idx<0){
			throw new IndexOutOfBoundsException();
		}
		Node<E> n = beginMarker.next;
		for(int i = 0;i<idx;i++){
			n = n.next;	
		}
		return n;
	}
	
	private void addAfter(Node<E> n,E x){
		Node<E> node = new Node<E>(null,x);
		n.next = node;
		size++;
		modCount++;
	}
	
	public void remove(E e){
		Node<E> node1 = beginMarker;
		Node<E> node2 = beginMarker.next;
		while(node2!=null){
			if(e.equals(node2.item)){
				node1.next = node2.next;
			}
			node1=node1.next;
			node2=node2.next;
		}
	}
	
	public boolean addIfNotExist(E e){
		
		if(contain(e)){
			return false;
		}else{
			add(e);
			return true;
		}
	}
	
	public boolean contain(E e){
		Node<E> node = beginMarker.next;
		while(node!=null){
			if(e.equals(node.item)){
				return true;
			}
			node=node.next;
		}
		return false;
	}
	
	public  String toString(){
		Node<E> node = beginMarker.next;
		StringBuffer sb = new StringBuffer();
		while(node!=null){
			if(node.next==null){
				sb.append(node.item);
			}else{
				sb.append(node.item+",");
			}
			node = node.next;
		}
		return sb.toString();
	}
}

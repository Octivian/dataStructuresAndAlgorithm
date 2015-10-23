package com.lx.dataStructures.charpter3ListStackQueue.practice;



public class SinglyLinkedList11<E> {
	
	public static void main(String[] args) {
		SinglyLinkedList11<Object> slist = new SinglyLinkedList11<Object>();
		slist.add(1);
		slist.add(1);
		slist.add(2);
		slist.add(1);
		slist.add(1);
		slist.remove(1);
		System.out.println(slist.toString());
	}
	
	
	private int size;
	private int modCount;
	Node<E> beginMarker;
	
	public SinglyLinkedList11(){
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

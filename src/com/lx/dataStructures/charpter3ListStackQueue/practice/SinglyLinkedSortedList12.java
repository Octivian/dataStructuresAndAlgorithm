package com.lx.dataStructures.charpter3ListStackQueue.practice;



public class SinglyLinkedSortedList12<E> {
	
	
	public static void main(String[] args) {
		SinglyLinkedSortedList12<Integer> slist = new SinglyLinkedSortedList12<Integer>();
		slist.add(13);
		slist.add(23);
		slist.add(2333);
		slist.add(1);
		slist.add(56);
		System.out.println(slist.toString());
	}
	
	
	private Node<Comparable> head;
	private int theSize;

	SinglyLinkedSortedList12() {
		init();
	}

	void init() {
		theSize = 0;
		head = new Node<Comparable>();
		head.next = null;
	}

	boolean add(Comparable x) {
		if (contains(x))
			return false;
		else {
			Node<Comparable> p = head.next;
			Node<Comparable> trailer = head;
			while (p != null && p.data.compareTo(x) < 0) {
				trailer = p;
				p = p.next;
			}
			trailer.next = new Node<Comparable>(x);
			trailer.next.next = p;
			theSize++;
		}
		return true;
	}

	boolean contains(Comparable x) {
		Node<Comparable> p = head.next;
		while (p != null && p.data.compareTo(x) <= 0) {
			if (x.equals(p.data))
				return true;
			else
				p = p.next;
		}
		return false;
	}

	private class Node<Comparable> {
		Comparable data;
		Node next;

		Node() {
			this(null, null);
		}

		Node(Comparable d) {
			this(d, null);
		}

		Node(Comparable d, Node n) {
			data = d;
			next = n;
		}
	}
	
	public  String toString(){
		Node<E> node = head.next;
		StringBuffer sb = new StringBuffer();
		while(node!=null){
			if(node.next==null){
				sb.append(node.data);
			}else{
				sb.append(node.data+",");
			}
			node = node.next;
		}
		return sb.toString();
	}
}

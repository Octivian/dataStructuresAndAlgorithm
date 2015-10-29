package com.lx.dataStructures.charpter3ListStackQueue.practice;

import com.lx.dataStructures.charpter3ListStackQueue.MyLinkedList.Node;

public class SwitchInterfacingElement2 {

	public static void main(String[] args) {
		
	}
	
	private static void swapSinglyLinkedList(Node before){
		Node first = before.next;
		Node second = before.next.next;
		Node last = before.next.next.next;
		before.next = second;
		second.next = first;
		first.next = last;
	}
	
	private static void swapDoubleLinkedList(Node n){
		Node before = n.prev;
		Node next = n.next;
		Node after = n.next.next;
		before.next = next;
		next.prev = before;
		next.next = n;
		n.prev = next;
		n.next = after;
		after.prev = n;
	}
}

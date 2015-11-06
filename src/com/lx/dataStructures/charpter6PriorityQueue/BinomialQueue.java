package com.lx.dataStructures.charpter6PriorityQueue;

public class BinomialQueue <AnyType extends Comparable<? super AnyType>>{
	private static final int DEFAULT_TREES = 1;
	 private int currentSize;
	 
	 private static class Node<AnyType>{
		 AnyType e;
		 Node<AnyType> leftChild;
		 Node<AnyType> nextSibling;
		 
		 public Node(AnyType e) {
			 this(e,null,null);
		 }
		 
		 public Node(AnyType e,Node<AnyType> lt,Node<AnyType> nt) {
			 this.e = e;
			 this.leftChild = lt;
			 this.nextSibling = nt;
		 }
		 
	 }
}

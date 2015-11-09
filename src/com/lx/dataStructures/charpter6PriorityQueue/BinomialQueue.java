package com.lx.dataStructures.charpter6PriorityQueue;

public class BinomialQueue<AnyType extends Comparable<? super AnyType>> {

	private static final int DEFAULT_TREES = 1;

	private int currentSize;
	
	private Node<AnyType> [] trees;
	
	public BinomialQueue() {
		
	}
	
	public BinomialQueue(AnyType e) {
		
	}
	
	public void merge(BinomialQueue<AnyType> rhs){
		if(this == rhs)
			return;
		currentSize += rhs.currentSize;
		if(currentSize>capacity()){
			int maxLength = Math.max(trees.length,rhs.trees.length);
			expandTheTrees(maxLength+1);
		}
		
		for(int i = 0,j = 1;j <= currentSize;i++,j*=2){
			Node<AnyType> t1 = trees[i];
			Node<AnyType> t2 = i<rhs.trees.length?rhs.trees[i]:null;
			
		}
	}
	
	public void insert(AnyType e){
		merge(new BinomialQueue<AnyType>(e));
	}
	
	public AnyType findMin(){
		return null;
	}
	
	public AnyType deleteMin(){
		return null;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public void makeEmpty(){
		
	}
	
	private void expandTheTrees(int newNumberTrees){
		
	}
	
	
	/**
	 * 合并同样大小两颗二项树
	 * @param n1
	 * @param n2
	 * @return
	 */
	private Node<AnyType> combineTrees(Node<AnyType> n1,Node<AnyType> n2){
		if(n1.e.compareTo(n2.e)>0)
			return combineTrees(n2,n1);
		n2.nextSibling = n1.leftChild;
		n1.leftChild = n2;
		return n1;
	}
	
	private int capacity(){
		return (1<<trees.length)-1;//取2的指数幂的位运算,根据二项队列性质,也就是二项队列数组元素最大个数
	}
	
	private int findMinIndex(){
		return currentSize;
	}

	private static class Node<AnyType> {
		AnyType e;
		Node<AnyType> leftChild;
		Node<AnyType> nextSibling;

		public Node(AnyType e) {
			this(e, null, null);
		}

		public Node(AnyType e, Node<AnyType> lt, Node<AnyType> nt) {
			this.e = e;
			this.leftChild = lt;
			this.nextSibling = nt;
		}

	}
}

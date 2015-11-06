package com.lx.dataStructures.charpter6PriorityQueue;

public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {
	
	private Node<AnyType> root;
	
	public LeftistHeap(){
		root = null;
	}
	
	public void merge(LeftistHeap<AnyType> rhs){
		if(this == rhs)
			return;
		root = merge(root,rhs.root);
		rhs.root = null;
	}
	
	public void insert(AnyType e){
		root = merge(new Node<AnyType>(e),root);
	}
	
	public AnyType findMin(){
		return null;
	}
	
	/**
	 * 删除根节点后，合并左右子树
	 * @return
	 */
	public AnyType deleteMin(){
		if(isEmpty()){
			throw new NullPointerException();
		}
		AnyType minItem = root.e;
		root = merge(root.left,root.right);
		return minItem;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	private Node<AnyType> merge(Node<AnyType> h1,Node<AnyType> h2){
		
		if(h1 == null)
			return h2;
		if(h2 == null)
			return h1;
		if(h1.e.compareTo(h2.e)<0)
			return merge1(h1,h2);
		else
			return merge1(h2,h1);
	}
	
	/**
	 * 将h2与h1的右子树合并，形成新的h1的右子树，判断h1的组左右子树是否满足左式堆的性质，不满足则交换其左右子树，再将h1节点npl设置为新右子树的npl+1
	 * 
	 * @param h1 根节点较小的树
	 * @param h2 根节点较大的树
	 * @return
	 */
	private Node<AnyType> merge1(Node<AnyType> h1,Node<AnyType> h2){
		if(h1.left==null)
			h1.left = h2;
		else{
			h1.right = merge(h1.right,h2);
			if(h1.left.npl<h1.right.npl)
				swapChildren(h1);
			h1.npl = h1.right.npl+1;
		}
		return h1;
	}
	
	private void swapChildren(Node<AnyType> n1){
		Node<AnyType> temp = n1.left;
		n1.left = n1.right;
		n1.right = temp;
	}

	private static class Node<AnyType>{
		AnyType e;
		Node<AnyType> left;
		Node<AnyType> right;
		int npl;
		
		public Node(AnyType e) {
			this(e,null,null);
		}
		
		public Node(AnyType e,Node<AnyType> left,Node<AnyType> right){
			this.e = e;
			this.left = left;
			this.right = right;
			npl = 0;
		}
	}
}

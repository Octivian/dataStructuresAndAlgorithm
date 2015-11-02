package com.lx.dataStructures.charpter4Tree.practice;

public class MyTreeSet11<AnyType extends Comparable<? super AnyType>> {
	
	Node<AnyType> root;
	int modCount = 0;
	private static class Node<AnyType>{
		AnyType e;
		Node<AnyType> left;
		Node<AnyType> right;
		Node<AnyType> parent;
		public Node(AnyType e) {
			this(e,null,null,null);
		}
		
		public Node(AnyType e,Node<AnyType> parent,Node<AnyType> left,Node<AnyType> right) {
			this.e = e;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	
	public MyTreeSetIterator iterator(){
		return new MyTreeSetIterator();
	}
	
	private class MyTreeSetIterator implements java.util.Iterator<AnyType>{
		private Node<AnyType> current = findMin(root);
		private Node<AnyType> pre;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		private boolean atEnd = false;
		@Override
		public boolean hasNext() {
			return !atEnd;
		}

		@Override
		public AnyType next() {
			if(modCount != expectedModCount)
				throw new  java.util.ConcurrentModificationException( );
			if(!hasNext())
				throw new java.util.NoSuchElementException( );
			AnyType nextItem = current.e;
			pre = current;
			if(current.right!=null){
				current = findMin(current.right);
			}else{
				Node<AnyType> child = current;
				current = current.parent;
				while(current!=null&&!current.left.e.equals(child)){
					child = current;
					current = current.parent;
				}
				if(current == null){
					atEnd = true;	
				}
			}
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			if(!okToRemove)
				throw new IllegalStateException( );
			if(modCount != expectedModCount)
				throw new  java.util.ConcurrentModificationException( );
			MyTreeSet11.this.remove(pre.e, pre);
			okToRemove = false;
		}
		
	}
	
	public void insert(AnyType e){
		insert(e,root,null);
	}
	
	public void remove( AnyType e ){ 
		root = remove(e, root); 
	}
	
	private Node<AnyType> remove(AnyType e,Node<AnyType> n){
		if(n == null){
			return n;
		}
		int result = e.compareTo(n.e);
		if(result < 0){
			n = remove(e,n.left);
		}else if(result > 0){
			n = remove(e,n.right);
		}else if(n.left!=null&&n.right!=null){
			n.e = findMin(n.right).e;
			n.right = remove(n.e,n.right);
		}else{
			modCount++;
			Node<AnyType> child = n.left == null?n.right:n.left;
			child.parent = n.parent;
			n = child;
		}
		return n;
	}
	
	private Node<AnyType> insert(AnyType e,Node<AnyType> n,Node<AnyType> pn){
		if(n == null){
			modCount++;
			return new Node<AnyType>(e,null,null,pn);
		}
		int result = e.compareTo(n.e);
		if(result<0){
			n = insert(e,n.left,n);
		}else if(result>0){
			n = insert(e,n.right,n);
		}
		return  n;
	}
	
	private Node<AnyType> findMin(Node<AnyType> n){
		if ( n == null ) 
			return null;
		if(n.left == null){
			return n;
		}
		return findMin(n.left);
	}
}

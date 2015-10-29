package com.lx.dataStructures.charpter4Tree;



/**
 * 二叉排序树/二叉查找树
 * @author lx
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {
	
	private Node<E> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void clear(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(E e){
		root = insert(e,root);
	}
	
	private Node<E> insert(E e,Node<E> n){
		if(n == null){
			return new Node<E>(e);
		}
		if(e.compareTo(n.e)>0){
			n.rightNode = insert(e,n.rightNode);
		}
		if(e.compareTo(n.e)<0){
			n.leftNode = insert(e,n.leftNode);
		}
		return n;
	}
	
	public boolean contains(E e){
		return contains(e,root);
	}
	
	private boolean contains(E e,Node<E> n){
		if(n == null)
			return false;
		if(e.compareTo(n.e)>0){
			return contains(e,n.rightNode);
		}else if(e.compareTo(n.e)<0){
			return contains(e,n.leftNode);
		}else{
			return true;
		}
	}
	
	public E findMin(){
		if(isEmpty()) throw new NullPointerException();
		return findMin(root).e;
	}
	
	private Node<E> findMin(Node<E> n){
		if(n == null){
			return null;
		}else if(n.leftNode == null){
			return n;
		}
		return findMin(n.leftNode);
	}
	
	public E findMax(){
		if(isEmpty()) throw new NullPointerException();
		return findMax(root).e;
	}
	
	private Node<E> findMax(Node<E> n){
		if(n != null)
			while(n.rightNode!=null)
				n = n.rightNode;
		
		return n;
	}
	
	public void remove(E e){
		remove(e,root);
	}
	
	private Node<E> remove(E e,Node<E> n){
		if(n == null){
			return n;
		}
		int compare = e.compareTo(n.e);
		if(compare<0){
			n.leftNode = remove(e,n.leftNode);
		}else if(compare>0){
			n.rightNode = remove(e,n.rightNode);
		}else if(n.leftNode!=null&&n.rightNode!=null){//双叉节点
			n.e = findMin(n.rightNode).e;
			n.rightNode = remove(n.e,n.rightNode);
		}else{
			n = n.leftNode!=null?n.leftNode:n.rightNode;  //单叉或叶子节点
		}
		return n;
	}
	
	private static class Node<E>{
		E e;
		Node<E> leftNode;
		Node<E> rightNode;
		Node(E e){
			this(e,null,null);
		}
		Node(E e,Node<E> left,Node<E> right){
			this.e = e;
			this.leftNode = left;
			this.rightNode = right;
		}
	}
	
	public void printTree(){
		printTree(root);
	}
	
	
	/**
	 * 中序遍历打印
	 * 左树，中间，右树顺序遍历
	 * @param n
	 */
	private void printTree(Node<E> n){
		if(n != null){
			printTree(n.leftNode);
			System.out.println(n.e);
			printTree(n.rightNode);
		}
	}
}

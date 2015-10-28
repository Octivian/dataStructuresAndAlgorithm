package com.lx.dataStructures.charpter4Tree;

public class AVLTree<E extends Comparable<E>> {

	AVLNode<E> root;
	
	private  class AVLNode<E extends Comparable<E>>{
		AVLNode<E> left;
		AVLNode<E> right;
		E e;
		int height;
		
		AVLNode(E e){
			this(e,null,null);
		}
		
		AVLNode(E e,AVLNode<E> left,AVLNode<E> right){
			this.e = e;
			this.left = left;
			this.right = right;
			height = 0;
		}
	}
	
	private int height(AVLNode<E> n){
		return n == null?-1:n.height;
	}
	
	public void insert(E e){
		insert(e,root);
	}
	
	private AVLNode<E> insert(E e,AVLNode<E> n){
		if(n == null){
			return new AVLNode<E>(e);
		}
		int result = e.compareTo(n.e);
		
		if(result<0){
			n.left = insert(e,n.left);
			if(height(n.left)-height(n.right)==2){//左树比右树高
				if(e.compareTo(n.left.e)<0){//左左的情况 
					n = singlyRoatationLeft(n);
				}else{						//左右的情况 
					n = doubleRoatationLeft(n);
				}
			}
		}else if(result>0){
			n.right = insert(e,n.right);
			if(height(n.right)-height(n.left)==2){//右树比左树高
				if(e.compareTo(n.right.e)<0){//右左的情况
					n = doubleRoatationRight(n);
				}else{					     //右右的情况
					n = singlyRoatationRight(n);
				}
			}
		}
		n.height = Math.max(n.right.height, n.left.height)+1;
		return n;
	}
	
	private AVLNode<E> singlyRoatationLeft(AVLNode<E> n){
		AVLNode<E> rootNode = n.left;
		n.left = rootNode.right;
		rootNode.right = n;
		//调整后 两个节点的高度有了变化  
		n.height = Math.max(height(n.left),height(n.right))+1;
		rootNode.height = Math.max(height(rootNode.left), n.height)+1;
		return rootNode;
	}
	
	private AVLNode<E> singlyRoatationRight(AVLNode<E> n){
		AVLNode<E> rootNode = n.right;
		n.right = rootNode.left;
		rootNode.left = n;
		//调整后 两个节点的高度有了变化  
		n.height = Math.max(height(n.left),height(n.right))+1;
		rootNode.height = Math.max(height(rootNode.right), n.height)+1;
		return rootNode;
	}
	
	private AVLNode<E> doubleRoatationLeft(AVLNode<E> n){
		n.left = singlyRoatationRight(n.left);
		return singlyRoatationLeft(n);
	}
	
	private AVLNode<E> doubleRoatationRight(AVLNode<E> n){
		n.right = singlyRoatationLeft(n.right);
		return singlyRoatationRight(n);
	}
	
}

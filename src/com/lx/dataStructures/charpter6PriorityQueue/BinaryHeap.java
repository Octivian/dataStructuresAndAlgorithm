package com.lx.dataStructures.charpter6PriorityQueue;

public class BinaryHeap <AnyType extends Comparable<? super AnyType>>{
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int currentSize;
	
	private AnyType[] array;

	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}
	
	public BinaryHeap(int capacity){
//		array = new AnyType[capacity];
	}
	
	public BinaryHeap(AnyType[] array){
		currentSize = array.length;
		this.array = (AnyType[]) new Comparable[(currentSize+2)*11/10];
		int i = 1;
		for (AnyType anyType : array) {
			array[i++] = anyType;
		}
		buildheap();
	}
	
	//percolate up
	public void insert(AnyType e){
		//check array lenth before insert
		if(currentSize == array.length - 1)
			enlargeArray(array.length<<1);
		
		//find hole   
		int hole = ++currentSize;
		//根据堆序性质设父节点下标为i，右子节点下标为2i+1,左子结点下标为2i，父节点为子节点下标二分之一
		while(hole>1&&array[hole].compareTo(array[hole>>1])<0){
			array[hole] = array[hole>>1];
			hole = hole >> 1;
		}
		array[hole] = e;
	}
	
	public AnyType findMin(){
		return array[1];
	}
	
	public AnyType deleteMin(){
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		AnyType minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public void makeEmpty(){
		currentSize = 0;
		array = null;
	}
	//下滤
	private void percolateDown(int hole){
		int child;
		AnyType tmp = array[hole];
		while(hole<<1<=currentSize){
			child = hole<<1;
			//如果有右子树，比较右子树和左子树大小 ，将较小的作为父节点要替换的子树
			if(child!=currentSize&&array[child+1].compareTo(array[child])<0)
				child++;
			if(array[child].compareTo(array[hole])<0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}
	
	private void buildheap(){
		//从倒数第二层的最后一个元素开始下滤，构建二叉堆
		for (int i = currentSize>>1; i >0; i--) {
			percolateDown(i);
		}
	}
	
	private void enlargeArray(int newSize){
		
	}
	
}

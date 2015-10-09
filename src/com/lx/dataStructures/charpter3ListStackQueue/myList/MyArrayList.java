package com.lx.dataStructures.charpter3ListStackQueue.myList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author lx
 * 
 * 1.保持基础数组，数组容量，以及存储在其中的项数
 * 2.提供一种机制可改变数组容量。通过获得一个比老数组大一倍的新数组，将老数组中的元素拷贝到新数组来扩容，允许虚拟机回收老数组
 * 3.提供get,set实现
 * 4.提供基本方法，size，isEmpty，clear(这些为典型的单行程序)，remove，两种不同版本的add，如果数组大小和容量相同，那么这两个add将增加数组容量
 * 5.提供一个实现iterator接口的类。这个类存储迭代序列中的下一项的下标，并提供next，hasNext，remove等方法实现，MyArrayList的迭代器方法直接返回实现iterator接口的该类的新构造的实例
 *
 */
public class MyArrayList {
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	
	private Object[] theItems;
	
	public MyArrayList() {
		clear();
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return theSize == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(theSize);
	}
	
	public void clear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public void ensureCapacity(int newCapacity){
		if(newCapacity<theSize)
			return;
		Object[] old = theItems;
		theItems = new Object[newCapacity];
		for(int i = 0;i<size();i++){
			theItems[i] = old[i];
		}
	}
	
	public Object get(int idx){
		if(idx<0||idx>=theSize)
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	
	public Object set(int idx,Object x){
		if(idx<0||idx>=theSize)
			throw new ArrayIndexOutOfBoundsException();
		Object old = theItems[idx];
		theItems[idx] = x;
		return old;
	}
	
	public boolean add(Object x){
		add(size(),x);
		return true;
	}
	
	public void add(int idx,Object x){
		if(size()==theItems.length)
			ensureCapacity(size()*2+1);
		for(int i = theSize;i>idx;i--){
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = x;
		theSize++;
	}
	
	public Object remove(int idx){
		Object removed = theItems[idx]; 
		for(int i = idx;i<theSize-1;i++){
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removed;
	}
	
	public Iterator<Object> iterator(){
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<Object>{

		
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current<size();
		}
		
		@Override
		public Object next() {
			if(!hasNext())
				throw new NoSuchElementException();
			return theItems[current++];
		}


		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}
		
	}
}

package com.lx.dataStructures.charpter5Hash;

public class QuadraticProbingHashTable<AnyType> {
	
	private static final int DEFAULT_SIZE = 11;
	
	private HashEntry<AnyType> [] array;
	
	private int currentSize;
	
	public QuadraticProbingHashTable(){
		this(DEFAULT_SIZE);
	}

	
	public QuadraticProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}
	
	public  void makeEmpty(){
		currentSize = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}
	
	public  void insert(AnyType e){
		int pos = findPos(e);  
		if(isActive(pos))
			return;
		array[myhash(e)] = new HashEntry<AnyType>(e,true);
		if(++currentSize>array.length>>1)
			rehash();
	}
	
	public  boolean contain(AnyType e){
		return isActive(findPos(e));
	}
	
	public void remove(AnyType e){
		array[findPos(e)].isActive = false;
	}
	
	private void allocateArray(int arraySize){
		array = new HashEntry[arraySize];
	}
	
	private boolean isActive(int currentPos){
		return array[currentPos]!=null&&array[currentPos].isActive;
	}
	
	public AnyType find(AnyType e){
		int idx = findPos(e);
		return isActive(idx)?array[idx].e:null;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	private int findPos(AnyType e){
		int offset = 1;
		int pos = myhash(e);
		while(array[pos]!=null&&!array[pos].equals(e)){
			pos += offset;
			offset+=2;				//偏移量每次在当前位置累加二，当前位置+1，当前位置+3，+5，+7 ，替代了不必要的平方运算
			if(pos>=array.length)
				pos-=array.length;  //此处看似有可能数组越界，offset不断累加2，当pos大于两倍的array.length，array[pos]是越界的
									//但是，离散表不可能是满的，并且平方探测可以探测整个表，所以会在某个array[pos] == null时退出
		}
		return pos;
	}
	
	private void rehash(){
		HashEntry<AnyType> [] old = array;
		allocateArray(nextPrime(old.length*2));
		currentSize = 0;
		for (int i = 0; i < old.length; i++) {
			if(old[i]!=null&&old[i].isActive)
				insert(old[i].e);
		}
	}
	
	private int myhash(AnyType e){
		return currentSize;
	}
	
	private static int nextPrime(int n){
		while(!isPrime(n))
			n++;
		return n;
	}
	
	private static boolean isPrime(int n){
		if(n%2==0){
			return false;
		}else{
			for (int i = 3; i < Math.sqrt(n)+1; i=i+2) {
				if(n%i==0)
					return false;
			}
			return true;
		}
	}
	
	private static  class HashEntry<AnyType>{
		public AnyType e;
		public boolean isActive;
		
		public HashEntry(AnyType e) {
			this(e,true);
		}
		
		public HashEntry(AnyType e,boolean isActive) {
			this.e = e;
			this.isActive = isActive;
		}
	}
	
	
}

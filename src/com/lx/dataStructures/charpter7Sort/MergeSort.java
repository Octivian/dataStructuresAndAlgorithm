package com.lx.dataStructures.charpter7Sort;

/**
 * 归并排序(分治)
 * @author lx
 *
 */
public class MergeSort {
	
	
	/**
	 * best:N(logN)
	 * avg:N(logN)
	 * worst:N(logN)
	 * T(1)=O(1)
	 * T(N)=2T(N/2)+N
	 * 
	 * @param a
	 */
	
	public static <AnyType extends Comparable<? super AnyType>>  void mergeSort(AnyType [] a){
		AnyType [] tmpA = (AnyType[]) new Comparable[a.length];
		mergeSort(a,tmpA,0,a.length-1);
	}
	
	private static <AnyType extends Comparable<? super AnyType>>  void mergeSort(AnyType [] a,AnyType [] tmpA,int left,int right){
		if(left<right){
			int mid = (left+right)>>1;
			mergeSort(a, tmpA, left, mid);
			mergeSort(a, tmpA, mid+1, right);
			merge(a,tmpA,left,mid+1,right);
		}
	}
	
	/**
	 * 
	 * @param a
	 * @param tmpA
	 * @param left
	 * @param right
	 * @param rightEnd
	 */
	private static <AnyType extends Comparable<? super AnyType>>  void merge(AnyType [] a,AnyType [] tmpA,int left,int right,int rightEnd){
		int leftEnd = right - 1;
		int tempPos = left;
		int numElements = rightEnd - left + 1;
		
		while(left<=leftEnd&&right<=rightEnd){
			if(a[left].compareTo(a[right])<0)
				tmpA[tempPos++] = a[left++];
			else
				tmpA[tempPos++] = a[right++];
		}
		while(left<=leftEnd)
			tmpA[tempPos++] = a[left++];
		while(right<=rightEnd)
			tmpA[tempPos++] = a[right++];
		for (int i = 0; i < numElements;i++) {
			a[rightEnd] = tmpA[rightEnd];
			rightEnd--;
		}
	}
}

package com.lx.dataStructures.charpter7Sort.practice;

public class QuickSort19 {
	
	private static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		Integer[] a =  {3,1,4,1,9,20,2,6,5,3,100};
		quickSort(a,0,a.length-1);
//		insertionSort(a,0,a.length-1);
		for(Integer n:a)
			System.out.print(n+",");
	}
	
	
	private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType [] a,int left,int right){
		if(left+CUTOFF <= right){
			AnyType pivot = getPivot(a, left, right);
			AnyType temp;
			int i = left,j = right - 1; 
			while(true){
				while(a[++i].compareTo(pivot)<0);
				while(a[--j].compareTo(pivot)>0);
				if(i<j){
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}else
					break;
			}
			a[right-1] = a[i];
			a[i] = pivot;
			quickSort(a,left,i-1);
			quickSort(a,i+1,right);
		}else{
			insertionSort(a,left,right);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType [] a,int left,int right){
		int j = 0;
		for (int i = left+1; i < right+1; i++) {
			AnyType temp = a[i];
			for (j = i - 1; j >=0&&a[j].compareTo(temp)>0; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = temp;
		}
	}
	
	
	
	

	/**
	 * 三数中值分隔法获取枢纽元，并把枢纽元放在倒数第二位置
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <AnyType extends Comparable<? super AnyType>> AnyType getPivot(AnyType [] a,int left,int right){
		AnyType temp;
		int mid = (left+right)>>1;
		if(a[left].compareTo(a[right])>0){
			temp = a[left];
			a[left] = a[right];
			a[right] = temp;
		}
		if(a[left].compareTo(a[mid])>0){
			temp = a[left];
			a[left] = a[mid];
			a[mid] = temp;
		}
		if(a[mid].compareTo(a[right])>0){
			temp = a[mid];
			a[mid] = a[right];
			a[right] = temp;
		}
		temp = a[right - 1];
		a[right - 1] = a[mid];
		a[mid] = temp;
		return a[right - 1];
	}
}

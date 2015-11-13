package com.lx.dataStructures.charpter7Sort.practice;

public class InsertionSort1 {

	public  static <AnyType extends Comparable<? super AnyType>> void main(String[] args) {
		AnyType[] a = (AnyType[]) new Comparable[]{3,1,4,1,5,9,2,6,5};
		insertionSort(a);
		for(AnyType n:a)
			System.out.print(n+",");
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){
		AnyType temp;
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			for (j = i; j > 0&&temp.compareTo(a[j-1])<0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = temp;
		}
	}
}

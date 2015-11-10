package com.lx.dataStructures.charpter7Sort;

public class InsertionSort {
	
	public static void main(String[] args) {
		Integer[] a =  {81,94,11,96,12,35,17,95,28,58,41,75,15};
		insertionSort(a);
		for(Integer num:a)
		System.out.print(num+",");
	}

	public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){
		int j;
		for (int i = 1; i < a.length; i++) {
			AnyType temp = a[i];
			for (j = i; j >0&&temp.compareTo(a[j-1])<0; j--) //一小皆小
				a[j]=a[j-1];
			a[j] = temp;
		}
	}
}

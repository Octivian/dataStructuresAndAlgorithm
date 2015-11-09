package com.lx.dataStructures.charpter7Sort;

public class InsertionSort {

	public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){
		int j;
		for (int i = 1; i < a.length; i++) {
			AnyType temp = a[i];
			for (j = 0; j < i&&temp.compareTo(a[j])<0; j++) //一小皆小
				a[j+1]=a[j];
			a[j] = temp;
		}
	}
}

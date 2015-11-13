package com.lx.dataStructures.charpter7Sort;

public class QuickSelect {

	public static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType [] a,int k){
		quickSelect(a, 0, a.length-1,k);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void quickSelect(AnyType [] a,int left,int right,int k){
		AnyType pivot = getPivot(a,left,right);
		AnyType temp;
		int i = left,j=right-1;
		while(true){
			while(a[--i].compareTo(pivot)<0);
			while(a[--j].compareTo(pivot)>0);
			if(i<j){
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}else
				break;
		}
		a[right - 1] = a[i];
		a[i] = pivot;
		if(k<=i)
			quickSelect(a,left,i-1,k);
		else if(k > i+1)
			quickSelect(a,i+1,right,k);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> AnyType getPivot(AnyType [] a,int left,int right){
		int mid = (left+right)>>1;
		AnyType temp;
		if(a[left].compareTo(a[mid])>0){
			temp = a[left];
			a[left] = a[mid];
			a[mid] = temp;
		}
		if(a[mid].compareTo(a[right])>0){
			temp = a[right];
			a[right] = a[mid];
			a[mid] = temp;
		}
		if(a[left].compareTo(a[right])>0){
			temp = a[right];
			a[right] = a[left];
			a[left] = temp;
		}
		temp = a[right -1];
		a[right -1] = a[mid];
		a[mid] = temp;
		return a[right -1];
	}
}

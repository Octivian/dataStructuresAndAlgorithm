package com.lx.dataStructures.charpter7Sort.practice;

public class MergeSortWithoutRecursive16 {
	
	public static void main(String[] args) {
		Integer[] a =  {142, 543, 123, 65, 453, 879, 572, 434, 111, 242, 811, 102};
		mergeSort(a);
		for(Integer n:a)
			System.out.print(n+",");
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a){
		AnyType[] tmp = (AnyType[]) new Comparable[a.length];
		int rightEnd;
		int gap = 0;
		for (int i = 2; i < a.length<<1; i=i<<1) {
			gap = i;
			if(a.length<i)
				i = a.length;
			for (rightEnd = i-1; rightEnd < a.length; rightEnd+=i) {
				int left = (rightEnd-i)+1;
				int leftEnd = left+(gap>>1)-1;
				merge(a,tmp,left,leftEnd,rightEnd);
			}
		}
	}
	

	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a,AnyType[] tmp,int left,int leftEnd,int rightEnd){
		int right = leftEnd+1;
		int i = left;
		int num = rightEnd - left + 1; 
		while(left<=leftEnd&&right<=rightEnd){
			if(a[left].compareTo(a[right])<0){
				tmp[i++] = a[left++];
			}else{
				tmp[i++] = a[right++];
			}
		}
		while(left<=leftEnd){
			tmp[i++] = a[left++];
		}
		while(right<=rightEnd){
			tmp[i++] = a[right++];
		}
		for (int j = 0; j < num; j++) {
			a[rightEnd] = tmp[rightEnd];
			rightEnd--;
		}
	}
}

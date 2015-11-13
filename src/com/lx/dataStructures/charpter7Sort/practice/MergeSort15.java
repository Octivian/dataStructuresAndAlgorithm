package com.lx.dataStructures.charpter7Sort.practice;

/**
 * 归并排序（分治）
 * @author lx
 *
 */
public class MergeSort15 {

	public static void main(String[] args) {
		Integer[] a =  {142, 543, 123, 65, 453, 879, 572, 434, 111, 242, 811, 102};
		mergeSort(a);
		for(Integer n:a)
			System.out.print(n+",");
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a){
		AnyType[] tmp = (AnyType[]) new Comparable[a.length];
		mergeSort1(a,tmp,0,a.length-1);
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void mergeSort1(AnyType[] a,AnyType[] tmp,int left,int right){
		if(left<right){
			int mid = (left+right)>>1;
			mergeSort1(a,tmp,left,mid);
			mergeSort1(a,tmp,mid+1,right);
			merge(a,tmp,left,mid,right);
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a,AnyType[] tmp,int left,int leftEnd,int rightEnd){
		int right = leftEnd+1;
		
		
		/**
		 * 
		 */
		int i = left;
		/**
		 * 
		 */
		
		int num = rightEnd - left +1;
		
		while(left<=leftEnd&&right<=rightEnd){
			if(a[left].compareTo(a[right])>0){
				tmp[i++] = a[right++];
			}else{
				tmp[i++] = a[left++];
			}
		}
		while(left<=leftEnd){
			tmp[i++] = a[left++];
		}
		while(right<=rightEnd){
			tmp[i++] = a[right++];
		}
		for (int j = 0; j < num;j++) {
			a[rightEnd] = tmp[rightEnd];
			rightEnd--;
		}
	}
}

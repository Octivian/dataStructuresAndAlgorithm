package com.lx.dataStructures.charpter7Sort;

public class ShellSort {
	
	public static void main(String[] args) {
		Integer[] a =  {81,94,11,96,12,35,17,95,28,58,41,75,15};
		shellSort1(a);
		System.out.println(a);
	}

	/**
	 * 增量序列h1,h2,h3...ht
	 * 每次循环增量序列保证a[i]<=a[i+hk]
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a){
		int n = a.length;
		int gap,i,j;
		//循环增量序列
		for (gap = n / 2; gap > 0; gap /= 2)
			for (i = gap; i < n; i++)
				for (j = i - gap; j >= 0 && a[j].compareTo(a[j + gap])>0; j -= gap){
					AnyType temp = a[j];
					a[j] = a[j+gap];
					a[j+gap] = temp;
				}
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void shellSort1(AnyType[] a){
		int gap,j;
		for (gap = a.length>>1; gap > 0; gap=gap>>1) {
			for (int i = gap; i < a.length; i++) {
				for (j = i; j >=gap&&a[j].compareTo(a[j-gap])<0; j-=gap) {
					AnyType temp = a[j];
					a[j] = a[j-gap];
					a[j-gap] = temp;
				}
			}
		}
	}
}

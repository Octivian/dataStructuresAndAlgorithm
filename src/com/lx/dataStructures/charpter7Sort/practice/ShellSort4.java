package com.lx.dataStructures.charpter7Sort.practice;

public class ShellSort4 {
	
	public static <AnyType extends Comparable<? super AnyType>> void main(String[] args) {
		Integer[]  a = {9,8,7,6,5,4,3,2,1};
		int[]  b = {1,3,7};
		shellSort(a,b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}

	private static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType [] a,int [] b){
		AnyType temp ;
		for (int i = b.length-1; i >= 0; i--) {
			System.out.println("");
			for (int u = 0; u < a.length; u++) {
				System.out.print(a[u]+",");
			}
			for (int j = b[i]; j < a.length; j++) {
				for (int k = j - b[i];k>=0&&a[k].compareTo(a[k+b[i]])>0;k-=b[i] ) {
					temp = a[k];
					a[k] = a[k+b[i]];
					a[k+b[i]] = temp;
				}
			}
			System.out.println("");
			System.out.println(b[i]);
		}
	}
}

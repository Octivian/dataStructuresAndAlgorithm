package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;


/**
 * 对于排好序的数组从小到大
 * 找出是否存在A[i] = i; 
 * @author lx
 *
 */
public class FindIndexInSortedArray15 {
	public static void main(String[] args) {
		System.out.println(normalFind(new int[]{0,1,2,3,4,6,10,13}));
	}
	
	/**
	 * 普通查找
	 * 算法复杂度O(N)线性
	 * @param a
	 * @return
	 */
	private static int normalFind(int [] a){
		for(int i = 0;i<a.length;i++){
			System.out.println("a");
			if(i+1 == a[i]){
				return a[i];
			}else if(i+1 < a[i]){
				return -1;
			}
		}
		return -1;
	}
	
	/**
	 * 二分查找 
	 * 算法复杂度O(logN)(随着循环总量减半)
	 * @param a
	 * @return
	 */
	private static int binaryFind1(int [] a){
		int first = 0,last = a.length-1;
		while(first<last){
			System.out.println("a");
			int mid = (first+last)/2;
			if(a[mid]<mid+1){
				first = mid+1;
			}else if(a[mid]>mid+1){
				return -1;
			}else{
				return a[mid];
			}
		}
		return -1;
	}
}

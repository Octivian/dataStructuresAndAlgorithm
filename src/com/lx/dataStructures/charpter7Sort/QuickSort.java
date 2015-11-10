package com.lx.dataStructures.charpter7Sort;

/**
 * 快速排序
 * 
 * @author SecondTheWorld
 *
 */
public class QuickSort {
	
	private static final int CUTOFF = 10;

	public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType [] a){
		quickSort(a, 0, a.length-1);
	}
	
	
	/**
	 * 快速排序主方法
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType [] a,int left,int right){
		if(left+CUTOFF <= right){
			AnyType pivot = getMid(a,left,right);
			int i = left,j = right -1;
			AnyType temp;
			while(true){
				//移动 i j,与pivot比较大小，分割
				while(a[++i].compareTo(pivot)<0);
				while(a[--j].compareTo(pivot)>0);
				if(i < j){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}else
					break;
			}
			//分割后将i位置元素与pivot交换
			a[right-1] = a[i];
			a[i] = pivot;
			
			//分治递归
			quickSort(a,left,i-1);
			quickSort(a,i+1,right);
		}else     //如果元素数小于10，则用插入排序
			insertionSort(a,left,right);
	}
	
	/**
	 * 插入排序
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType [] a,int left,int right){
		int j;
		for (int i = 1; i <= right ; i++) {
			AnyType temp = a[i];
			for (j = i; j > 0&&a[j - 1].compareTo(temp)>0; j--) {
				a[j] = a[j - 1]; 
			}
			a[j] = temp;
		}
	}
	
	
	
	/**
	 * 利用三数中指分割法寻找枢纽元（寻找头，尾，中间三个数中间大小的数作为枢纽元）,
	 * 由于已知枢纽元，和头尾元素大小，进行初始分割数组（枢纽元放到倒数第二位置，因为相对有序，头尾元素中大于枢纽元的元素放入最后位置，头尾元素中小于枢纽元的元素放入首位），
	 * 所以i为left+1, j为right-2
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>> AnyType getMid(AnyType [] a,int left,int right){
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

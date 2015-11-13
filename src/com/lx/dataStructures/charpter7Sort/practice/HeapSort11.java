package com.lx.dataStructures.charpter7Sort.practice;

/**
 * 1.buildHeap
 * 2.deleteMax
 * @author lx
 *
 */
public class HeapSort11 {

	public static void main(String[] args) {
		Integer[] a =  {142, 543, 123, 65, 453, 879, 572, 434, 111, 242, 811, 102};
		heapSort(a);
		for(Integer n:a)
			System.out.print(n+",");
	}
	
	/**
	 * use percDown:
	 * 1.buildHeap
	 * 2.deleteMax
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a){
		//从最后一个元素的父元素依次向前逐个节点下滤，buildHeap
		for (int i = a.length-2>>1; i >= 0; i--) {
			percDown(a,i,a.length);
		}
		//从最后一个节点逐个向前依次与每个percDown后的堆顶元素替换，delete max
		
		AnyType temp;
		for (int i = a.length - 1; i >= 0; i--) {
			temp  = a[i];
			a[i] = a[0];
			a[0] = temp;
			percDown(a,0,i);
		}
	}
	
	/**
	 * 下滤
	 * @param a 要排序的数组
	 * @param i 需要下滤节点的数组下标  （构建堆时从倒数第二层的最后一个元素依次向前逐个节点下滤，删除MAX是从0，也就是堆顶开始下滤）
	 * @param n 下滤边界节点下标（因为堆排序将堆顶最大元素放置堆末尾，所以堆末尾已拍好序，构建堆时为数组长度）
	 */
	private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a,int i,int n){
		AnyType e = a[i];
		//确保当前节点有左儿子并且在边界之内
		while((i<<1)+1<n){
			int child = (i<<1)+1;
			//确保有右儿子并且右儿子大于左儿子，用较大子节点来和父节点比较大小
			if(child+1<n&&a[child].compareTo(a[child+1])<0)
				child++;
			if(e.compareTo(a[child])<0){
				a[i] = a[child];
			}else
				break;
			i = child;
		}
		a[i] = e;
	}
}

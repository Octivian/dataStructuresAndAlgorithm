package com.lx.dataStructures.charpter7Sort;

/**
 * 堆排序
 * @author lx
 *
 * @param <AnyType>
 */
public class HeapSort<AnyType> {

	/**
	 * 填坑
	 * @param a
	 * @param i
	 * @param n
	 */
	public static <AnyType extends Comparable<? super AnyType>>  void percDown(AnyType[] a,int i,int n){
		int child = 0;
		AnyType tmp = a[i];
		//确保有左儿子
		while(2*i+1 < n){
			//下滤到左儿子
			child = 2*i+1;
			//左儿子的下标不是最后一个元素下标（证明有右儿子），并且右儿子大于左儿子，则当前元素跟较大儿子比较
			if(child!=n-1&&a[child].compareTo(a[child+1])<0)
				child++;
			if(tmp.compareTo(a[child])<0)
				a[i] = a[child];
			else
				break;
			i = child;
		}
		a[i] = tmp;
		
	}
	
	/**
	 * O(N*logN)（平均运行时间）
	 * 
	 * 第一部分构造堆 @link BinaryHeap # buildheap()  运行时间O(N)
	 * 第二部分删除头一个元素并下滤，最多用到2logi次比较
	 * 
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>>  void heapSort(AnyType[] a){
		//build heap
		//从倒数第二层最后一个元素逐个向前进行下滤比较替换大值向上,构成一个父节点为较大值的二叉堆
		for (int i = a.length>>1; i > 0; i--) {
			percDown(a,i,a.length);
		}
		//deleteMax
		//交换第一个元素（最大元素）和最后一个元素
		for (int i = a.length-1; i > 0; i--) {
			AnyType temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			//下滤
			percDown(a,0,i);//下滤排除交换到末尾的节点，所以参数i
		}
	}
	
}

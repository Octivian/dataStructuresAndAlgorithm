package com.lx.dataStructures.maxSumSubsequence;

/**
 * P28
 * 
 * 算法1,2属于穷举法
 * 算法3属于分治法
 * 算法4属于动态规划法
 * @author lx
 *
 */
public class MaxSumSubsequence {
	

	public static void main(String[] args) {
//		System.out.println(sum3(new long[]{-2, 11, -4, 13, -5, -2},0,5));
		System.out.println(sum4(new long[]{-2, 11, -4, 13, -5, -2}));
	}
	
	/**
	 * 算法1（最直观）
	 * 时间算法复杂度  O(n^3)
	 * @param a
	 * @return
	 */
	private  static long sum1(long[] a){
		long maxSum=0;
		for(int i = 0;i<a.length;i++){//循环起点
			for(int j = i;j<a.length;j++){//循环终点
				long thisSum = 0;
				for(int k = i;k<=j;k++){//确定好的起点终点间的序列求和
					thisSum+=a[k];
				}
				System.out.println(thisSum);
				if(thisSum>maxSum){
					maxSum = thisSum;
				}
			}
		}     
		  
		return maxSum;
	}
	
	
	/**
	 * 算法2(循环终点顺便求和)
	 * 时间算法复杂度  O(n^2)
	 * @param a
	 * @return
	 */
	private static long sum2(long[] a){
		long maxSum=0;
		for(int i = 0;i<a.length;i++){//循环起点
			long thisSum = 0;
			for(int j = i;j<a.length;j++){//循环终点
				thisSum+=a[j];
				if(thisSum>maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	
	/**
	 * 算法3（分治）
	 * 时间算法复杂度 
	 * 	假设该算法需要T(N)时间(N代表输出个数)   
	 * 	
	 * 	1.当N=1时，则left==right，直接返回，所以T(1)=1
	 * 	
	 * 	2.去除常量计算则为，两次递归调用，加上两次单个儿循环。
	 * 	     两次递归调用的输出各为N/2，两次单个儿循环的输出个数也为N/2，所以T(N)=2*T(N/2)+N
	 * 	     则有方程组：
	 * 				T(1)=1;
	 * 				T(N)=2*T(N/2)+N;
	 * 	
	 * 	     根据以上方程组可得T(2)=4=2^1*2，T(4)=12=2^2*3，T(8)=32=2^3*4，T(16)=80=2^4*5
	 * 	  
	 * 	     假设N=2^k,则T(N)=2^k*(k+1)=N*(K+1)=N*k+N=NlogN+N=O(NlogN)
	 * 	
	 * @param a
	 * @return
	 */
	private static long sum3(long[] a,int left,int right){
		System.out.println("left:"+left+",right:"+right);
		if(left == right){
			if(a[left]>0){
				return a[left];
			}else{
				return 0;
			}
		}
		int center = (left + right)/2;
		System.out.println("center: "+center);
		//前半部分最大子序列
		long firstHalf=sum3(a,left,center);
		System.out.println("firstHalf:"+firstHalf);
		//后半部分最大子序列
		long lastHalf=sum3(a,center+1,right);
		System.out.println("lastHalf:"+lastHalf);
		long firstHalfWithLastElement=0;//前半部分包含前半部分最后一个元素的最大子序列
		long tem1 = 0;
		for(int i = center;i>=left;i--){
			tem1+=a[i];
			if(tem1>firstHalfWithLastElement){
				firstHalfWithLastElement = tem1;
			}
		}
		long lastHalfWithFirstElement=0;//后半部分包含后半部分第一个元素的最大子序列
		long tem2 = 0;
		for(int i = center+1;i<=right;i++){
			tem2+=a[i];
			if(tem2>lastHalfWithFirstElement){
				lastHalfWithFirstElement = tem2;
			}
		}
		long combine = lastHalfWithFirstElement+firstHalfWithLastElement;
		System.out.println("combine:"+combine);
		
		if(firstHalf>lastHalf){
			if(firstHalf>combine){
				return firstHalf;
			}else{
				return combine;
			}
		}else{
			if(lastHalf>combine){
				return lastHalf;
			}else{
				return combine;
			}
		}
	}
	
	
	/**
	 * 算法4
	 * 时间算法复杂度  O(N)
	 * 
	 * 在任意时刻，都能对已经读入的数据给出最大子序列和，这种特性叫  联机算法（online algorithem）
	 * 
	 * 仅需常量空间，以及随输入数据增多而只有线性的时间消耗几乎是  完美算法
	 * 
	 * @param a
	 * @return
	 */
	private static long sum4(long[] a){
		long maxSum = 0,thisSum=1;
		for(int i =0;i<a.length;i++){
			thisSum+=a[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum<0){
				thisSum=0;
			}
		}
		return maxSum;
	}
}

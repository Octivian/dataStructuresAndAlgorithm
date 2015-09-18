package com.lx.dataStructures.maxSumSubsequence;


public class MaxSumSubsequence {

	public static void main(String[] args) {
		System.out.println(fib(new long[]{-2, 11, -4, 13, -5, -2}));
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	private  static long fib(long[] a){
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

}

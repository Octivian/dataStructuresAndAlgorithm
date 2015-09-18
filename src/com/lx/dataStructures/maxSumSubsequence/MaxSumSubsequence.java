package com.lx.dataStructures.maxSumSubsequence;


public class MaxSumSubsequence {

	public static void main(String[] args) {
		System.out.println(sum2(new long[]{-2, 11, -4, 13, -5, -2}));
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
				System.out.println(thisSum);
				if(thisSum>maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	
	/**
	 * 算法3
	 * 时间算法复杂度  O(n^2)
	 * @param a
	 * @return
	 */
	private static long sum3(long[] a){
		long maxSum=0;
		for(int i = 0;i<a.length;i++){//循环起点
			long thisSum = 0;
			for(int j = i;j<a.length;j++){//循环终点
				thisSum+=a[j];
				System.out.println(thisSum);
				if(thisSum>maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

}

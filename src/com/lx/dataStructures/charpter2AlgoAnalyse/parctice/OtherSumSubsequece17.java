package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

/**
 * 子序列问题拓展
 * 
 * @author lx
 *
 */
public class OtherSumSubsequece17 {
	public static void main(String[] args) {					// 12   -27   12
		System.out.println(maxProductSubsequence2(new double[] { -2.5, 4, 0, 3, 0.5, 8, -1,1.5,-2,-1}));
		// System.out.println(minSumSubsequece3(new int[]{-2, 11, -20,-4, 13,
		// -5, -2},0,6));
	}

	/**
	 * 求最大子序列乘积
	 *  O(N)
	 * 
	 * @param a
	 * @return
	 */
	private static double maxProductSubsequence2(double[] v) {
		double maxt = 1;
		double mint = 1;
		double maxv = v[0];
		int count = 0;
		for (int i = 0; i < v.length; i++) {
			count++;
			if (v[i] == 0) {
				maxt = 1;
				mint = 1;
				if (maxv<0)
					maxv = 0;
			} else {

				double minrst = mint * v[i];
				double maxrst = maxt * v[i];

				maxt = maxrst > minrst ? maxrst : minrst;//包含当前元素子序列的最大乘积
				mint = maxrst > minrst ? minrst : maxrst;//包含当前元素子序列的最小乘积

				if (maxt < v[i])
					maxt = v[i];
				if (maxv < maxt)
					maxv = maxt;
			}
		}
		System.out.println(count);
		return maxv;
	}

	/**
	 * 求最小正子序列和(应该有O(NlogN)算法) O(N^2)
	 * 
	 * @param a
	 * @return
	 */
	private static int minPositiveSumSubsequence1(int[] a) {
		int min = 65535;
		for (int i = 0; i < a.length; i++) {
			int temp = 0;
			for (int j = i; j < a.length; j++) {
				temp += a[j];
				if (temp > 0 && temp < min) {
					min = temp;
				}
			}
		}
		return min;
	}

	/**
	 * 
	 * 最小子序列和
	 * 动态规划(最小子序列和，此子序列首尾元素肯定小于0，整体也肯定小于0) O(N)
	 * 
	 * @param a
	 * @return
	 */
	private static int minSumSubsequece4(int[] a) {
		int min = 0, temp = 0;
		for (int i = 0; i < a.length; i++) {
			temp += a[i];
			if (temp > 0) {
				temp = 0;
			}
			if (temp < min) {
				min = temp;
			}

		}
		return min;
	}

	/**
	 * 最小子序列和
	 * 第一个循环：确定起点 第二个循环：确定终点 第三个循环：从起点到终点累加 O(N^3)
	 * 
	 * @param a
	 * @return
	 */
	private static int minSumSubsequece1(int[] a) {
		int min = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int theSum = 0;
				for (int k = i; k <= j; k++) {
					theSum += a[k];
				}
				if (theSum < min) {
					min = theSum;
				}
			}
		}
		return min;
	}

	/**
	 * 
	 * 最小子序列和
	 * 第一个循环：确定起点 第二个循环：确定终点同时累加判断 O(N^2)
	 * 
	 * @param a
	 * @return
	 */
	private static int minSumSubsequece2(int[] a) {
		int min = 0;
		for (int i = 0; i < a.length; i++) {
			int theSum = 0;
			for (int j = i; j < a.length; j++) {
				theSum += a[j];
				if (theSum < min) {
					min = theSum;
				}
			}
		}
		return min;
	}

	/**
	 * 最小子序列和
	 * 分治 
	 * O(NlogN)
	 * 
	 * @param a
	 * @return
	 */
	private static int minSumSubsequece3(int[] a, int left, int right) {
		if (right == left) {
			if (a[right] < 0) {
				return a[right];
			} else {
				return 0;
			}
		}
		int mid = (right + left) / 2;
		int lefthalf = minSumSubsequece3(a, left, mid);
		int righthalf = minSumSubsequece3(a, mid + 1, right);
		int lefthalfWithMid = 0;
		for (int i = mid; i >= left; i--) {
			lefthalfWithMid += a[i];
		}
		int righthalfWithMid = 0;
		for (int i = mid + 1; i <= right; i++) {
			righthalfWithMid += a[i];
		}
		int combine = righthalfWithMid + lefthalfWithMid;

		if (lefthalf < righthalf) {
			if (lefthalf < combine) {
				return lefthalf;
			} else {
				return combine;
			}
		} else {
			if (righthalf < combine) {
				return righthalf;
			} else {
				return combine;
			}
		}
	}

}

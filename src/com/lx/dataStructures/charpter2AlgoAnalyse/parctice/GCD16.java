package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

/**
 * 最大公约数
 * @author lx
 *
 */
public class GCD16 {
	
	public static void main(String[] args) {
		System.out.println(greatestCommonDivisor2(90,72));
	}
	
	/**
	 * 欧几里得算法求最大公因数
	 * 
	 * 定理：gcd(a,b) = gcd(b,a mod b) (a>b 且a mod b 不为0)
	 * 算法复杂度O(logN)
	 * @param a
	 * @param b
	 * @return
	 */
	private static int greatestCommonDivisor1(int a,int b){
		int count=1;
		while(b!=0){
			int factor=a%b;
			a = b;
			b = factor;
			System.out.println(count++);
		}
		return a;
	}
	
	/**
	 * 定理：gcd(a,b) = 2gcd(b/2,a/2) (a b are even,a>b)
	 * @param a
	 * @param b
	 * @return
	 */
	private static int greatestCommonDivisor2(int a,int b){
		return -1;
	}
}

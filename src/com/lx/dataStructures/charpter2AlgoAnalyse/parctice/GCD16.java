package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

/**
 * 最大公约数
 * @author lx
 *
 */
public class GCD16 {
	
	public static void main(String[] args) {
		System.out.println(greatestCommonDivisor2(81,72));
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
	 * 算法复杂度O(logN)
	 * a>b
	 * 定理：gcd(a,b) = 2gcd(a/2,b/2) (a b are even)
	 * 定理：gcd(a,b) = gcd((a+b)/2,(a-b)/2) (a b are odd)
	 * 定理：gcd(a,b) = gcd(a/2,b) (a is even,b is odd)
	 * 定理：gcd(a,b) = gcd(a,b/2) (a is odd,b is even)
	 * @param a
	 * @param b
	 * @return
	 */
	private static int greatestCommonDivisor2(int a,int b){
		System.out.println("a");
		if(a%b==0){
			return b;
		}
		if(b%a==0){
			return a;
		}
		if(a%2==0&&b%2==0){
			return 2*greatestCommonDivisor2(a/2,b/2);
		}else if(a%2!=0&&b%2!=0){
			return greatestCommonDivisor2((a+b)/2,(a-b)/2);
		}else if(a%2==0&&b%2!=0){
			return greatestCommonDivisor2(a/2,b);
		}else{
			return greatestCommonDivisor2(a,b/2);
		}
	}
}

package com.lx.dataStructures.log;


/**
 * P33
 * 
 * 运行时间对数出现规律：
 * 		如果一个算法使用常数时间将问题大小削减为1/2,那么就是O(logN) 、
 * 		参见binarySearch和power1方法
 * 		
 * 	另一方面：
 * 		如果一个算法使用常数时间将问题大小减少一个常数的数量，那么就是O(N)（线性）
 * 
 * @author lx
 *
 */
public class RunTimeWithLog {
	public static void main(String[] args) {
//		System.out.println(binarySearch(new int[]{-13,-5,-3,5,12,20,32,190,192,193,194,195,291,391,591,691},691));
//		System.out.println(greatestCommonFactor(1989,1590));
		System.out.println(power1(2,8));
	}
	
	/**
	 * 折半查找
	 * 算法复杂度O(logN)
	 * 
	 * 确定循环次数，每循环一次，所需处理的输入减半。
	 * 假设输入为128个，则最多（假设X所在第一位或最后一位或不存在在数组中）每次循环后输入分别为64,32,16,8,4,2,1,0,-1,也就是循环9次，
	 * T(128)=7+1,T(8)=3+1,T(16)=4+1 （加1是因为循环跳出的判断也算作一次操作）
	 * 所以算法复杂度为O(logN)
	 * 
	 * 体现了一种contain操作
	 * 
	 * 如果是insert操作（给排好序的数组中插入），则只能O(N)了
	 * 
	 * 
	 * 
	 * @param a 排好序的数组
	 * @param x	需要查找的数
	 * @return
	 */
	private static int binarySearch(int [] a,int x){
		int first = 0,last= a.length-1;
		
		while(first<=last){
			int mid = (first+last)/2;
			if(x>a[mid]){
				first = mid+1;
			}else if(x<a[mid]){
				last = mid-1;
			}else{
				return mid;
			}
			System.out.println("a");
		}
		return -1;
	}
	
	/**
	 * 欧几里得算法求最大公因数
	 * 算法复杂度O(logN)
	 * @param a
	 * @param b
	 * @return
	 */
	private static int greatestCommonFactor(int a,int b){
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
	 * 求x的n次幂
	 * 最普通的递归 可改写成简单for循环
	 * 算法复杂度O(N)(相乘N-1次)
	 * @param x
	 * @param n
	 * @return
	 */
	private static int power(int x,int n){
		System.out.println("a");
		if(n<=1){
			return x;
		}else{
			return x*power(x,n-1);
		}
	}
	
	/**
	 * 求x的n次幂
	 * 不要重复计算
	 * 算法复杂度O(logN)
	 * @param x
	 * @param n
	 * @return
	 */
	private static long power1(long x,int n){
		System.out.println("a");
		if(n<=1){
			return x;
		}else{
			if(n%2==0){
				return power1(x*x,n/2);
			}else{
				return power1(x*x,n/2)*x;
			}
		}
	}
}

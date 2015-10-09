package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

public class PowerWithoutRecursive23 {
	public static void main(String[] args) {
		System.out.println(getPowerWithoutRecursive2(2,8));
	}
	
	/**
	 * 不用递归求幂
	 * O(N)
	 * @param num
	 * @param power
	 * @return
	 */
	private static long getPowerWithoutRecursive1(long num,long power){
		long total = 1;
		int count = 0;
		for(int i = 0;i<power;i++){
			count++;
			total=total*num;
		}
		System.out.println(count);
		return total;
	}
	
	
	/**
	 * 不用递归求幂
	 * O(logN)
	 * @param num
	 * @param power
	 * @return
	 */
	private static long getPowerWithoutRecursive2(long num,long power){
		long pw = 1;
		int count = 0;
		while (power > 0) {
			count++;
	        if (power % 2 == 1)
	            pw *= num;
	        num *= num;
	        power /= 2;
	    }
		System.out.println(count);
		return pw;
	}
}

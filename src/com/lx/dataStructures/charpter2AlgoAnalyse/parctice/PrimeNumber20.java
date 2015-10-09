package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

public class PrimeNumber20 {
	public static void main(String[] args) {
		System.out.println(getBinaryPostion(100));
	}
	
	/**
	 * 判断一个数是否为素数
	 * O(N)
	 * 
	 * @param num
	 * @return
	 */
	private static boolean isPrimeNumber1(long num){
		for(long i = 2;i<num;i++){
			if(num%i==0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断一个数是否为素数
	 * O(N^1/2)
	 * @param num
	 * @return
	 */
	private static boolean isPrimeNumber2(long num){
		if(num%2==0){
			return true;
		}else{
			for(long i = 3;i<Math.sqrt(num)+1;i=i+2){
				if(num%i==0){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 获得一个数的二进制位数
	 * 
	 * @param num
	 * @return
	 */
	private static long getBinaryPostion(long num){
		int i = 0;
		while(num>>i>1){
			i++;
		}
		return i+1;
	}
}

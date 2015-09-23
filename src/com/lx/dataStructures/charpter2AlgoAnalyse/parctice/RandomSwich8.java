package com.lx.dataStructures.charpter2AlgoAnalyse.parctice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * P39  2.8随机置换
 * 
 * 
 * @author tianpo
 *
 */
public class RandomSwich8 {
	public static void main(String[] args) {
		for(Integer a:algo1(1,5))
			System.out.println(a);
//		System.out.println(algo3(1,5));
	}
	
	/**
	 * 随机置换算法1
	 * @param a
	 * @param b
	 * @return
	 */
	private static List<Integer> algo1(int a,int b){
		Random rand = new Random();
		List array= new ArrayList<Integer>();
		int count = 0;
		while(true){
			count++;
			int num = rand.nextInt(b-a+1)+a;
			if(array.size() == 0)
				array.add(num);
			int j;
			for(j = 0;j<array.size();j++){
				if(array.get(j).equals(new Integer(num))){
					break;
				}
			}
			if(j==array.size())
			array.add(num);
			if(array.size()==b-a+1)
				break;
		}
		System.out.println(count);
		return array;
	}
	
	/**
	 * 随机置换算法3
	 * @param a
	 * @param b
	 * @return
	 */
	private static int [] algo3(int a,int b){
		int [] array = new int [b-a+1];
		Random rand = new Random();
		for(int i = 0;i<b-a+1;i++){
			array[i] = i+1;
		}
		
		for(int i = 0;i<b-a+1;i++){
			int num = rand.nextInt(b-a+1)+a;
			int temp = array[i];
			array[i] = array[num-1];
			array[num-1] = temp;
		}
		return array;
	}
}

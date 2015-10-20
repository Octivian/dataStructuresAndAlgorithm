package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnionLists5 {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(5);
		a.add(7);
		a.add(9);
		a.add(11);
		a.add(13);
//		a.add(10000);
//		a.add(25132);
//		a.add(26841);
//		a.add(556841);
//		a.add(1000000);
		b.add(2);
		b.add(4);
		b.add(6);
		b.add(8);
		b.add(10);
		b.add(12);
		b.add(14);
		List<Integer> intersecList = unionLists(a,b);
		for(Integer i:intersecList){
//			System.out.println(i);
		}
	}
	
	/**
	 * 合并两个排好序的list  O(2N)  O(N)
	 * @param a
	 * @param b
	 * @return
	 */
	private static List<Integer> unionLists(List<Integer> a,List<Integer> b){
		List<Integer> unionList = new ArrayList<Integer>();
		Iterator<Integer> itA = a.iterator();
		Iterator<Integer> itB = b.iterator();
		Integer itemA = itA.next();
		Integer itemB = itB.next();
		int count = 0;
		while(itemA!=0&&itemB!=0){
			count++;
			if(itemA<itemB){
				unionList.add(itemA);
				itemA=itA.hasNext()?itA.next():0;
			}else{
				unionList.add(itemB);
				itemB=itB.hasNext()?itB.next():0;
			}
		}
		if(itemA == 0){
			unionList.add(itemB);
			while(itB.hasNext()){
				unionList.add(itB.next());
			}
		}else if(itemB == 0){
			unionList.add(itemA);
			while(itA.hasNext()){
				unionList.add(itA.next());
			}
		}
		System.out.println(count);
		return unionList;
	}
}

package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntersectionLists4 {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(5);
		a.add(7);
		a.add(9);
		b.add(2);
		b.add(4);
		b.add(6);
		b.add(8);
		b.add(10);
		b.add(11);
		b.add(12);
		List<Integer> intersecList = intersection(a,b);
		for(Integer i:intersecList){
//			System.out.println(i);
		}
	}
	
	/**
	 * 两个排好序的list找交集  O(2N)  O(N)
	 * @param a
	 * @param b
	 * @return
	 */
	private static List<Integer> intersection(List<Integer> a,List<Integer> b){
		List<Integer> intersecList = new ArrayList<Integer>();
		Iterator<Integer> itA = a.iterator();
		Iterator<Integer> itB = b.iterator();
		int itemA = itA.next();
		int itemB = itB.next();
		int count = 0;
		while(itemA!=0&&itemB!=0){
			count++;
			if(itemA==itemB){
				intersecList.add(itemA);
				itemA = itA.hasNext()?itA.next():0;
				itemB = itB.hasNext()?itB.next():0;
			}else if(itemA>itemB){
				itemB = itB.hasNext()?itB.next():0;
			}else{
				itemA = itA.hasNext()?itA.next():0;
			}
		}
		System.out.println(count);
		return intersecList;
	}
	
}

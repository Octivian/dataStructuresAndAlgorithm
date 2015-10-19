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
		a.add(78);
		a.add(123);
		a.add(5555);
		b.add(2);
		b.add(78);
		b.add(110);
		b.add(123);
		b.add(1000);
		b.add(5555);
		b.add(100000);
		List<Integer> intersecList = intersection(a,b);
		for(Integer i:intersecList){
			System.out.println(i);
		}
	}
	
	/**
	 * 两个排好序的list找交集
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
		while(itemA!=0&&itemB!=0){
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
		return intersecList;
	}
	
}

package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JosephusProblem6 {
	
	static int count = 0;

	public static void main(String[] args) {
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		for (int i = 0; i < 20; i++) {
//			a.add(i);
//		}
//		System.out.println(getWinnerIndex(2, 2, a));
		pass(2,20);
	}

	/**
	 * O(N)
	 * @param x
	 * @param m
	 * @param n
	 * @return
	 */
	
	private static int getWinnerIndex(int x, int m, List<Integer> n) {
		if (n.size() == 1) {
			return n.get(0);
		} else {
			System.out.println(n.get(m));
			n.remove(m);
			m = (m+x)%n.size();
			return getWinnerIndex(x, m, n);
		}
	}

	
	/**
	 * O(N)
	 * @param m
	 * @param n
	 */
	public static void pass(int m, int n) {
		int i, j, mPrime, numLeft;
		ArrayList<Integer> L = new ArrayList<Integer>();
		for (i = 1; i <= n; i++)
			L.add(i);
		ListIterator<Integer> iter = L.listIterator();
		Integer item = 0;
		numLeft = n;
		mPrime = m % n;
		for (i = 0; i < n; i++) {
			mPrime = m % numLeft;
			if (mPrime <= numLeft / 2) {
				if (iter.hasNext())
					item = iter.next();
				for (j = 0; j < mPrime; j++){
					if (!iter.hasNext())
						iter = L.listIterator();
					item = iter.next();
				}
			} else {
				for (j = 0; j < numLeft - mPrime; j++) {
					if (!iter.hasPrevious())
						iter = L.listIterator(L.size());
					item = iter.previous();
				}
			}
			item--;
			System.out.print("Removed " + item + " ");
			iter.remove();
			if (!iter.hasNext())
				iter = L.listIterator();
			System.out.println();
			numLeft--;
		}
		System.out.println();
	}
}

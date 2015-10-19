package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Iterator;
import java.util.List;

public class PrintLots1 {

	public static void main(String[] args) {
		
	}
	
	private static void printLots(List<Integer> l,List<Integer> p){
		for(int i = 0;i<p.size();i++){
			int index = p.get(i);
			if(index<l.size()){
				System.out.println(l.get(index));
			}
		}
	}
	
	public static <AnyType> void printLotss(List<AnyType> L, List<Integer> P)
	{
		Iterator<AnyType> iterL = L.iterator();
		Iterator<Integer> iterP = P.iterator();
		AnyType itemL=null;
		Integer itemP=0;
		int start = 0;
		while ( iterL.hasNext() && iterP.hasNext() )
		{
			itemP = iterP.next();
			System.out.println("Looking for position " + itemP);
			while ( start < itemP && iterL.hasNext() )
			{
			start++;
			itemL = iterL.next();
			}
			System.out.println( itemL );
		}
	}
	
}

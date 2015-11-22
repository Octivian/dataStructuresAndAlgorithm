package com.lx.dataStructures.charpter9Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinPathWithWordLadders {

	/**
	 * build words graph 
	 * 
	 * @param adjacentWords words lib,key:anyword,value:every words in the list are changed one letter by the key word
	 * @param first 
	 * @param last	 
	 * @return
	 */
	public static Map<String,String> buildGraph(Map<String,List<String>> adjacentWords,String first){
		Map<String, String> graphMap = new HashMap<String,String>();
		LinkedList<String> vertexList = new LinkedList<String>();
		vertexList.addLast(first);
		while(!vertexList.isEmpty()){
			String word = vertexList.getFirst();
			List<String> list = adjacentWords.get(word);
			if(list!=null){
				for (String string : list) {
					if(graphMap.get(string)==null){
						graphMap.put(string, word);
						vertexList.addLast(string);
					}
				}
			}
		}
		graphMap.put(first, null);
		return graphMap;
	}
	/**
	 * find the word ladder(from last word back to the first,startword)
	 * @param wordGraph
	 * @param first
	 * @return
	 */
	public static List<String> findLadder(Map<String,String> wordGraph,String last){
		LinkedList<String> result = new LinkedList<String>();
		while((last = wordGraph.get(last))!=null){
			result.addFirst(last);	
		}
		return result;
	}
}

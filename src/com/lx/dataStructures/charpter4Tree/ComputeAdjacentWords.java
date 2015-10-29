package com.lx.dataStructures.charpter4Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 使用多个映射
 * @author Lx
 *
 */
public class ComputeAdjacentWords {
	
	
	/**
	 * 先按相同长度分组，再在相同长度的单词序列中按除去一个字母后剩余字母序列分组比较
	 * 89000个单词  4秒
	 * @param words
	 * @return
	 */
	private Map<String,List<String>> computeAdjacentWords3(List<String> words){
		TreeMap<Integer, List<String>> sizeMap = new TreeMap<Integer,List<String>>();
		TreeMap<String, List<String>> wordMap = new TreeMap<String,List<String>>();
		for (int i = 0; i < words.size(); i++) {
			update(sizeMap,words.get(i).length(),words.get(i));
		}
		for (Entry<Integer, List<String>> mapList:sizeMap.entrySet()) {
			List<String> valueList = mapList.getValue();
			int offset = mapList.getKey();
			for(int k = 0;k<offset;k++){
				TreeMap<String, List<String>> repMap = new TreeMap<String,List<String>>();
				for (String string : valueList) {
					String word = string.substring(0, k)+string.substring(k+1);
					update(repMap,word,string);
				}
				for (List<String> wordss:repMap.values()) {
					if(wordss.size()>=2)
						for(String word1:wordss)
							for(String word2:wordss)
								if(!word1.equals(word2))
									update(wordMap,word1,word2);
				}
			}
		}
		return wordMap;
	}
	
	
	/**
	 * 只比较相同长度单词
	 * 89000个单词  51秒
	 * @param words
	 * @return
	 */
	private Map<String,List<String>> computeAdjacentWords2(List<String> words){
		TreeMap<Integer, List<String>> sizeMap = new TreeMap<Integer,List<String>>();
		TreeMap<String, List<String>> wordMap = new TreeMap<String,List<String>>();
		for (int i = 0; i < words.size(); i++) {
			update(sizeMap,words.get(i).length(),words.get(i));
		}
		for (List<String> valueList:sizeMap.values()) {
			for (int i = 0; i < valueList.size(); i++) {
				for (int j = i+1; j < valueList.size(); j++) {
					if(compare(words.get(i),words.get(j))){
						update(wordMap,valueList.get(i),valueList.get(j));
						update(wordMap,valueList.get(j),valueList.get(i));
					}
				}
			}
		}
		return wordMap;
	}
	
	
	
	
	/**
	 * 单纯暴力比较
	 * 89000个单词  96秒
	 * @param words
	 * @return
	 */
	private Map<String,List<String>> computeAdjacentWords1(List<String> words){
		
		TreeMap<String, List<String>> treeMap = new TreeMap<String,List<String>>();
		
		for (int i = 0; i < words.size(); i++) {
			for (int j = i+1; j < words.size(); j++) {
				if(compare(words.get(i),words.get(j))){
					update(treeMap,words.get(i),words.get(j));
					update(treeMap,words.get(j),words.get(i));
				}
			}
		}
		return treeMap;
	}
	

	private boolean compare(String word1,String word2){
		if(word1.length()!=word2.length())
			return false;
		int diff = 0;
		for (int i = 0; i < word1.length(); i++) {
			if(word1.charAt(i)!=word2.charAt(i)){
				if(++diff>1)
					return false;
			}
		}
		return diff == 1;
	}
	
	private  <KeyType> void update(Map<KeyType,List<String>> mapList,KeyType key,String value){
		List<String> list = mapList.get(key);
		if(list == null){
			list = new ArrayList<String>();
			mapList.put(key, list);
		}
		list.add(value);
	}
}

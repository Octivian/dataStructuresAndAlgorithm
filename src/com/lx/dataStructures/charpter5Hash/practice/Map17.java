package com.lx.dataStructures.charpter5Hash.practice;

import com.lx.dataStructures.charpter5Hash.QuadraticProbingHashTable;

public class Map17 <KeyType, ValueType>{
	
	private QuadraticProbingHashTable<Entry<KeyType,ValueType>> items;
	
	private static class Entry<KeyType,ValueType>{
		KeyType key;
		ValueType value;
		public Entry(KeyType key,ValueType value) {
			this.key = key;
			this.value = value;
		}
	}

	public Map17(){
		items = new QuadraticProbingHashTable<Map17.Entry<KeyType,ValueType>>();
	}
	
	public void put(KeyType key,ValueType value){
		Entry<KeyType, ValueType> entry = new Entry<KeyType, ValueType>(key, value);
		items.insert(entry);
	}
	
	public ValueType get(KeyType key){
		Entry<KeyType, ValueType> entry = new Entry<KeyType, ValueType>(key,null);
		return items.find(entry).value;
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public void makeEmpty(){
		items.makeEmpty();
	}
	
}

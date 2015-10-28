package com.lx.dataStructures.charpter3ListStackQueue.practice;

public class ThreeStacksWithOneArray26 {

	int stackSize = 300;
	int indexUsed = 0;
	int[] stackPointer = { -1, -1, -1 };//三个栈的偏移量
	StackNode[] buffer = new StackNode[stackSize * 3];

	void push(int stackNum, int value) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;//设置当前栈在数组中偏移量
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
	}

	int pop(int stackNum) {
		int value = buffer[stackPointer[stackNum]].value;//获取当前栈顶值
		int lastIndex = stackPointer[stackNum];//获取当前栈顶在数组中偏移量
		stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;//
		buffer[lastIndex] = null;
		indexUsed--;
		return value;
	}

	int peek(int stack) {
		return buffer[stackPointer[stack]].value;
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;  
	}

	class StackNode {
		public int previous;
		public int value;
		public StackNode(int p, int v) {
			value = v;
			previous = p;
		}
	}
}

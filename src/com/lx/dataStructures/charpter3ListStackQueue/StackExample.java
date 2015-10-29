package com.lx.dataStructures.charpter3ListStackQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
//		System.out
//				.println(checkBracketsString("public static void main(String[] args) {}private static  boolean checkBracketsString(String s){char [] array = s.toCharArray();if(stack.isEmpty())}{()[()]}"));
//		System.out.println(infixToSuffix("e-(a-b*c)*d"));
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println();
		for(int i = 0 ;i<15000;i++){
			arrayList.add("a");
		}
		tailRecursive(arrayList.iterator());
	}
	
	
	
	public static void tailRecursive(Iterator<String> ite){
		if(!ite.hasNext()){
			return;
		}else{
			ite.next();
			tailRecursive(ite);
		}
	}

	/**
	 * 利用栈特性校验字符串中,括号语法合法性
	 * 
	 * @param s
	 * @return
	 */
	private static boolean checkBracketsString(String s) {
		char[] array = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : array) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty())
					return false;
				if (c == ')') {
					c = '(';
				} else if (c == ']') {
					c = '[';
				} else {
					c = '{';
				}
				char currentChar = stack.pop();
				if (currentChar != c) {
					return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

//	/**
//	 * 中缀表达式转为后缀表达式
//	 * 
//	 * @param expression
//	 * @return
//	 */
//	private static String infixToSuffix(String expression){
//		char [] array = expression.toCharArray();
//		Stack<Character> stack = new Stack<Character>();
//		String suffixString = "";
//		for(char c:array){
//			if(c!='+'&&c!='-'&&c!='*'&&c!='/'&&c!='('&&c!=')'){
//				suffixString+=c;
//			}else{
//				if(stack.isEmpty()){
//					stack.push(c);
//				}else{
//					char top = stack.pop();
//					if(c == ')'){
//						suffixString+=top;
//						stack.pop();
//					}else if(top == '('){
//						stack.push(top);
//						stack.push(c);
//					}else{
//						char priorityChar = comparePriority(top,c);
//						if(priorityChar != top){//当前操作符优先级高
//							stack.push(top);
//							stack.push(c);
//						}else{//top优先级高
//							suffixString+=top;
//							if(!stack.isEmpty()){
//								suffixString+=stack.pop();
//							}
//							stack.push(c);
//						}
//					}
//					char priorityChar = comparePriority(top,c);
//					if(priorityChar != top){//当前操作符优先级高
//						if(c == ')'){
//							suffixString+=top;
//							stack.pop();
//						}else{
//							stack.push(top);
//							stack.push(c);
//						}
//					}else{//top优先级高
//						if(top == '('){
//							stack.push(top);
//							stack.push(c);
//						}else{
//							suffixString+=top;
//							if(!stack.isEmpty()){
//								char top1 = stack.pop();
//								if(comparePriority(top1,c)!=top1||top1 == '('){
//									stack.push(top1);
//									stack.push(c);
//								}else{
//									suffixString+=top1;
//									stack.push(c);
//								}
//							}else{
//								stack.push(c);
//							}
//						}
//					}
//				}  
//			}
//		}
//		while(!stack.isEmpty()){
//			suffixString+=stack.pop();
//		}
//		return suffixString;
//	}

	private static char comparePriority(char a, char b) {
		if (a == '+' || a == '-') {
			if (b == '+' || b == '-') {
				return a;
			} else {
				return b;
			}
		} else if (a == '*' || a == '/') {
			if (b == '(' || b == ')')
				return b;
			else {
				return a;
			}
		} else {
			return a;
		}
	}

}

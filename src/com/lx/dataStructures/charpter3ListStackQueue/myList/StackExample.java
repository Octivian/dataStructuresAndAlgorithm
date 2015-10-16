package com.lx.dataStructures.charpter3ListStackQueue.myList;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
//		System.out
//				.println(checkBracketsString("public static void main(String[] args) {}private static  boolean checkBracketsString(String s){char [] array = s.toCharArray();if(stack.isEmpty())}{()[()]}"));
		System.out.println(infixToSuffix("a+b*c+(d*e+f)*g"));
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

	/**
	 * 中缀表达式转为后缀表达式
	 * 
	 * @param expression
	 * @return
	 */
	private static String infixToSuffix(String expression){
		char [] array = expression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		String suffixString = "";
		for(char c:array){
			if(c!='+'&&c!='-'&&c!='*'&&c!='/'&&c!='('&&c!=')'){
				suffixString+=c;
			}else{
				if(stack.isEmpty()){
					stack.push(c);
				}else{
					char top = stack.pop();
					char priorityChar = comparePriority(top,c);
					if(priorityChar != top){//当前操作符优先级高
						if(c == ')'){
							suffixString+=top;
							stack.pop();
						}else{
							stack.push(top);
							stack.push(c);
						}
					}else{//top优先级高
						if(top == '('){
							stack.push(top);
							stack.push(c);
						}else{
							suffixString+=priorityChar;
							char top1 = stack.pop();
							if(comparePriority(top1,c)!=top1){
								stack.push(top1);
								stack.push(c);
							}else{
								suffixString+=top1;
								stack.push(c);
							}
						}
					}
				}  
			}
		}
		return suffixString;
	}

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

//	private static long calculateExpression(String expression) {
//		char[] array = expression.toCharArray();
//		Stack<Character> stack = new Stack<Character>();
//		for (char c : array) {
//
//		}
//	}

}

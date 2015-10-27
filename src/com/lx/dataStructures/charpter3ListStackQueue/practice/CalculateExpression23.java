package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Stack;

public class CalculateExpression23 {

	public static void main(String[] args) {
		System.out.println(calculateSuffixExpression(inFixToSuffix("3*(4-5-6)")));
	}
	
	private static String inFixToSuffix(String expression) {

		Stack<Character> s = new Stack<Character>();
		String result = "";
		for(Character token:expression.toCharArray()){
			if (token!='+'&&token!='-'&&token!='*'&&token!='/'&&token!='^'&&token!='('&&token!=')'){
				result+=token;
			}else {
				switch (token) {
				case ')':
					while (!s.empty() && s.peek() != '(') {
						result+=s.pop();
					}
					s.pop();
					break;
				case '(':
					s.push(token);
					break;
				case '^':
					while (!s.empty() && !(s.peek() == '^' || s.peek() == '(')) {
						result+=s.pop();
					}
					s.push(token);
					break;
				case '*':
				case '/':
					while (!s.empty() && s.peek() != '+' && s.peek() != '-' && s.peek() != '(') {
						result+=s.pop();
					}
					s.push(token);
					break;
				case '+':
				case '-':
					while (!s.empty() && s.peek() != '(') {
						result+=s.pop();
					}
					s.push(token);
					break;
				}
			}
		}
		while (!s.empty()){
			result+=s.pop();
		}
		return result;
	}
	
	private static double calculateSuffixExpression(String expression){
		Stack<Double> s = new Stack<Double>();
		char[] charArray = expression.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			Character c = charArray[i];
			if(!isOper(c)){
				s.push(Double.parseDouble(c.toString()));
			}else{
				Double num2 = s.pop();
				Double num1 = s.pop();
				Double result = 0d;
				if(c == '+'){
					result = num1+num2;
				}else if(c == '-'){
					result = num1-num2;
				}else if(c == '*'){
					result = num1*num2;
				}else if(c == '^'){
					result = Math.exp(num1*Math.log(num2));
				}
				s.push(result);
			}
		}
		return s.pop();
	}
	
	static boolean isOper(Character c){
		if(c == '+'||c == '-'||c == '*'||c == '/'){
			return true;
		}else{
			return false;
		}
	}
}

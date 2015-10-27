package com.lx.dataStructures.charpter3ListStackQueue.practice;

import java.util.Stack;

public class CalculateSuffixExpression22 {
	
	public static void main(String[] args) {
		System.out.println(calculateSuffixExpression("354--"));
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

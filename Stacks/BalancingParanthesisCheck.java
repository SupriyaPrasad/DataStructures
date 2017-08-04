package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancingParanthesisCheck {
	
	public boolean checkBalancingParanthesis(String expression){
		boolean b=false;
		
		Stack<Character> opening_brackets = new Stack<Character>();
		Map<Character, Character> bracket_pair_map = new HashMap<Character, Character>();
		bracket_pair_map.put(']', '[');
		bracket_pair_map.put('}', '{');
		bracket_pair_map.put(')', '(');
		
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)=='[' || expression.charAt(i)=='{' || expression.charAt(i)=='('){
				opening_brackets.push(expression.charAt(i));
				continue;
			}
			if(bracket_pair_map.containsKey(expression.charAt(i))){
				Character top = opening_brackets.peek();
				if(top==bracket_pair_map.get(expression.charAt(i))){
					opening_brackets.pop();
					b=true;
				}
				else{
					return false;
				}
			}

			
		}
		if(b==true && !opening_brackets.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancingParanthesisCheck test= new BalancingParanthesisCheck();
		String exp="[{(a+b+c)}]+{}";
		System.out.println(test.checkBalancingParanthesis(exp));
	}

}

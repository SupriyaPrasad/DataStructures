package Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixPostfix {
	
	public String convertInfixToPostfix(String expression){
		
		Stack<Character> symbols = new Stack<Character>();
		Map<Character,Integer> priority = new HashMap<Character,Integer>();
		String postfixVariables = "";
		String postfixOperations = "";

		priority.put('/',1);
		priority.put('*',2);
		priority.put('+',3);
		priority.put('-',4);
		priority.put('(',5);
		priority.put(')',6);
		priority.put(' ',7);
		
		symbols.push(' ');
		for(int i=0;i<expression.length();i++){
			char sym = expression.charAt(i);
			
			if(expression.charAt(i)=='('){
				while(expression.charAt(i)!=')'){
					if(priority.containsKey(expression.charAt(i)) && expression.charAt(i)!=')'){
						symbols.push(expression.charAt(i));
						System.out.println(expression.charAt(i));
					}
					else if(!priority.containsKey(expression.charAt(i))){
						postfixVariables = postfixVariables+expression.charAt(i);
						System.out.println(postfixVariables);
					}
					i++;
				}
				  if(expression.charAt(i)==')'){
					while(symbols.peek()!='('){
						postfixOperations = postfixOperations+symbols.peek();
						symbols.pop();
					}
					
				}
			}
			
			else if(priority.containsKey(sym) && (priority.get(sym) < priority.get(symbols.peek())) ){
				symbols.push(sym);
				System.out.println(sym);	
			}
			else if(priority.containsKey(sym) && priority.get(sym) > priority.get(symbols.peek())){
				while(symbols.peek()!=' '){
					if(symbols.peek()!=')' && symbols.peek()!='('){
						postfixOperations = postfixOperations+symbols.peek();
					}
					symbols.pop();
				}
				System.out.println(postfixOperations);
				symbols.push(sym);
			}
			else{
				System.out.println(sym);
				postfixVariables = postfixVariables+sym;
				System.out.println(postfixVariables);
			}
			
			postfixVariables = postfixVariables+postfixOperations;
			postfixOperations="";
		}
		if(!symbols.isEmpty()){
			while(!symbols.isEmpty()){
				if(symbols.peek()!=')' && symbols.peek()!='('){
					postfixOperations = postfixOperations+symbols.peek();
				}
				symbols.pop();
			}
			postfixVariables = postfixVariables+postfixOperations;
			System.out.println(postfixVariables);
		}
		
		return postfixVariables;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfixPostfix test = new InfixPostfix();
		String exp = "(A+B)*C";
		test.convertInfixToPostfix(exp);
	}

}

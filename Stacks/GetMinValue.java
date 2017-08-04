package Stacks;

import java.util.Stack;

public class GetMinValue {
	
	public int minValCalc(Stack<Integer> main_stack){
		Stack<Integer> sorted_stack = new Stack<Integer>();
		
		sorted_stack.push(main_stack.peek());
		
		while(!main_stack.isEmpty()){
			if(main_stack.peek()<=sorted_stack.peek()){
				sorted_stack.push(main_stack.peek());
				main_stack.pop();
			}
			else{
				sorted_stack.push(sorted_stack.peek());
				main_stack.pop();
			}
		}

		return sorted_stack.peek();
	}

	public static void main(String[] args){
		GetMinValue test= new GetMinValue();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(3);
		stack.push(1);
		stack.push(0);
		stack.push(8);
		stack.push(4);
		stack.push(9);
		stack.push(5);
		stack.push(-11);
		System.out.println(test.minValCalc(stack));
		
	}
}


package Stacks;

import java.util.ArrayList;
import LinkedList.Node;
import LinkedList.FirstCommon;
import java.util.Stack;

public class IntersectionPoint_Stacks {
	
	public int populateCommonElements(Node first_LL,Node second_LL){
		ArrayList<Integer> commonElementArray = new ArrayList<Integer>();
		
		Stack<Integer> firstStack= new Stack<Integer>();
		Stack<Integer> secStack= new Stack<Integer>();
		
		while(first_LL!=null){
			firstStack.push(first_LL.data);
			first_LL=first_LL.next;	
		}
		while(second_LL!=null){
			secStack.push(second_LL.data);
			second_LL=second_LL.next;
		}
		while(firstStack.peek()==secStack.peek()){
			commonElementArray.add(firstStack.peek());
			firstStack.pop();
			secStack.pop();
		}
		
		return commonElementArray.get(commonElementArray.size()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IntersectionPoint_Stacks find_common = new IntersectionPoint_Stacks();
		 LinkedList.FirstCommon first = new  LinkedList.FirstCommon();
		 LinkedList.FirstCommon second = new  LinkedList.FirstCommon();
		 first.insertEnd(1);
		 first.insertEnd(2);
		 second.insertEnd(1);
		 second.insertEnd(3);
		 first.combine(6, first.head, second.head);
		 first.insertEnd(8);
		 second.insertEnd(9);
		 
		 System.out.println(find_common.populateCommonElements(first.head, second.head));
	}
	}



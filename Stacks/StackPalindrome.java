package Stacks;

import java.util.Stack;

public class StackPalindrome {
	
	public void divide_to_stacks(char[] arr){
		Stack <Character> first_half = new Stack<Character>();
		Stack <Character> sec_half = new Stack<Character>();
		int i=0;
			while(arr[i]!='X'){
				first_half.push(arr[i]);
				i++;
			}
			if(arr[i]=='X'){
				i++;
			}
		
		while(i<arr.length){
			sec_half.push(arr[i]);
			i++;
		}
		System.out.println(check_palindrome(first_half,sec_half));
	}
	
	public boolean check_palindrome(Stack<Character> first_half, Stack<Character> sec_half){
		Character first_top = first_half.peek();
		Character sec_top = sec_half.peek();
		while(!first_half.isEmpty() && !sec_half.isEmpty()){ 
			if(first_top == sec_top){
			}

			else if(first_top != sec_top){
				return false;
				
			}
			first_top=first_half.pop();
			sec_top= sec_half.pop();
		}
		if(!first_half.isEmpty() || !sec_half.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackPalindrome test_palindrome= new StackPalindrome();
		int count=7;
		char[] string_arr= new char[count];
		string_arr[0]='a';
		string_arr[1]='b';
		//string_arr[2]='c';
		string_arr[3]='X';
		string_arr[4]='a';
		string_arr[5]='b';
		string_arr[6]='c';
		
		test_palindrome.divide_to_stacks(string_arr);

	}

}

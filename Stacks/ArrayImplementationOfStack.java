package Stacks;

public class ArrayImplementationOfStack {
	int size=5;
	int[] array= new int[size];
	int top=0;
	
	public void push(int num){
		if(top==0){
			array[top++]=num;
		}
		else if(top<size){
				array[top++]=num;
			}
	}
	
	public int pop(){
			int top_data=array[--top];
			top=top--;
			return top_data;
	}
	
	public void display(){
		for(int i=0;i<top;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayImplementationOfStack a = new ArrayImplementationOfStack();
		for(int i=1;i<=5;i++){
			a.push(i);
		}
		a.display();
		a.pop();
		a.pop();
		a.display();
	}

}

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingQueues {
	
	Queue<Integer> backendQueue = new LinkedList<Integer>();
	
	public void push(int n, Queue<Integer> q1){
		if(q1==null){
			q1 = new LinkedList<Integer>();
		}
		q1.add(n);
	}
	
	public int pop(Queue<Integer> q1){
		
		//reversing the queue elements using BackEnd queue

		if(q1.size()!=0){
			
			int i = 1;
			int size=q1.size();
			while(q1.size()>0 && i<size){
				backendQueue.add(q1.poll());
				i++;
			}
			
			return q1.poll();
		}
		else if(q1.size()==0){
			int i=1;
			int size_backend=backendQueue.size();
			while(backendQueue.size()>0 && i< size_backend){
				q1.add(backendQueue.poll());
				i++;
			}
			return backendQueue.poll();
		}
		return 0;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImplementationUsingQueues test_queue = new StackImplementationUsingQueues();
		Queue<Integer> q1= new LinkedList<Integer>();
		for(int i=1;i<=5;i++){
			test_queue.push(i, q1);
		}
		System.out.println(test_queue.pop(q1));

	}

}

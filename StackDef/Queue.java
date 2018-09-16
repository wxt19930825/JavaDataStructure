package StackDef;

public class Queue {
	
	private ArrayStack stack1;
	private ArrayStack stack2;
	
	public Queue() {
		stack1 = new ArrayStack(10);
		stack2 = new ArrayStack(10);
	}
	
	public Object pop() throws Exception{
		if (stack2.getTop()==-1) {
			while (stack1.getTop() !=-1) {
				Object obj = stack1.pop();
				stack2.push(obj);
			}
		}
		
		if (stack2.getTop() == -1) {
			throw new Exception("queue is empty");
		}
		return stack2.pop();
		
	}
	
	public Object push(Object obj){
		return stack1.push(obj);
	}
	
	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}

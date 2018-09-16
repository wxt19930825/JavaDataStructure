package StackDef;

public class Queue {
	
	private ArrayStack stack1;
	private ArrayStack stack2;
	
	public Queue() {
		stack1 = new ArrayStack(10);
		stack2 = new ArrayStack(10);
	}
	
	public Object pop() throws Exception{
		if (stack2.getSize()<=0) {
			while (stack1.getSize() >0) {
				Object obj = stack1.pop();
				stack2.push(obj);
			}
		}
		
		if (stack2.getSize() <=0) {
			throw new Exception("queue is empty");
		}
		return stack2.pop();
		
	}
	
	public Object push(Object obj){
		return stack1.push(obj);
	}
}

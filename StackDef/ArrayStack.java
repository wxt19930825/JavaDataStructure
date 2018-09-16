package StackDef;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 通过数组模拟栈
 * @author tian
 *
 */
public class ArrayStack {
	private Object[] elementData;
	
	private int top;
	
	private int size;
	
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 默认构造一个容量为10的栈
	 */
	public ArrayStack(){
		this.elementData = new Object[10];
		this.top = -1;
		this.size = 10;
	}
	
	public ArrayStack(int initSize){
		if (initSize <0) {
			throw new IllegalArgumentException("栈的初始容量不能为0");
		}
		
		this.elementData = new Object[initSize];
		this.top = -1;
		this.size = initSize;
	}
	
	
	public Object push(Object obj){
		isGrow(top+1);
		elementData[++top] = obj;
		return obj;
	}
	
	public Object pop(){
		if (this.top == -1) {
			throw new EmptyStackException();
		}
		Object obj = elementData[top];
		elementData[top]=null;
		this.top --;
		return obj;
	}
	
	public boolean isEmpty(){
		return top ==-1;
	}
	
	
	
	public boolean isGrow(int minSize){
		int oldSize = size;
		if (minSize >= oldSize) {
			int newSize = 0;
			if ((oldSize<<1) - Integer.MAX_VALUE >0) {
				newSize = Integer.MAX_VALUE;
			} else {
				newSize = (oldSize <<1);
			}
			
			this.size = newSize;
			elementData = Arrays.copyOf(elementData, size);
			return true;
			
		} else {
			return false;
		}
	}
	
	
}

package LinklistTable;

import java.text.SimpleDateFormat;

public class LinkedListOnePoint {
	
	/**
	 * ����ڵ㶨��
	 *
	 */
	private class Node {
		private Object data;
		private Node next;

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(Object data) {
			this.data = data;
		}
	}

	private Node head;
	private int size;

	public LinkedListOnePoint() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

	public Object headNode() {
		if (size == 0) {
			return null;
		}
		return head.data;
	}

	/**
	 * �������ͷ����һ���ڵ㣨��ջ��
	 * 
	 * @param obj
	 */
	public void insertInHead(Object obj) {
		Node node = new Node(obj);
		if (size == 0) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		size ++;
	}

	/**
	 * ɾ�������ͷ�ڵ㣨��ջ��
	 * @return
	 */
	public Object deleteHeadNode() {
		if (size == 0) {
			return null;
		}

		Object objct = head.data;
		if (head.next == null) {
			head = null;
		} else {
			head = head.next;
		}
		
		size--;
		return objct;

	}
	
	/**
	 * ɾ���ڵ�
	 * 1. �������ҵ�ɾ���Ľڵ�
	 * 2.Ȼ����ǰһ���ڵ�ָ��ɾ���ڵ����һ���ڵ�
	 * @param obj
	 * @return
	 */
	public boolean deleteNode(Object obj){
		if (size == 0) {
			return false;
		}
		
		Node previousNode  = null;
	    Node currentNode = head;
	    while (currentNode.data != obj) {
			if (currentNode.next == null) {
				return false;
			}
		}
		
		while (currentNode.data  !=obj) {
			if (currentNode.next == null) {
				return false;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if (currentNode == head) {
			this.deleteHeadNode();
		} else {
			previousNode.next = currentNode.next;
			size -- ;
		}
		
		return true;
	}
	
	/**
	 * �ж������Ƿ����ĳ��Ԫ��
	 * @param obj
	 * @return
	 */
	public boolean containObject(Object obj){
		if (size == 0) {
			return false;
		}
		
		Node n =head;
		while (n.next!=null) {
			if (n.data == obj) {
				return false;
			}else {
				n = n.next;
			}
		}
		
		return false;
	}
	
	public void display(){
		if (size == 0) {
			System.out.println("����Ϊ��");
		}
		
		Node n = head;
		
		while (n != null) {
			System.out.print("<-"+n.data);
			n= n.next;
		}
		
		System.out.println();
	}
	
	/**
	 * ����ڵ�
	 * @param obj
	 */
	public void insertNode(Object obj){
		Node newNode = new Node(obj);
		if (size ==0) {
			head = newNode;
		}else {
			Node node = head ;
			while (node.next!=null) {
				node = node.next;
			}
			
			node.next = newNode;
		}
		size++;
		
	}
	
	/**
	 * ��ת�����ݹ飩
	 * 
	 * �ڷ�ת�����ʱ����Ҫ�жϷ�ת�Ľڵ��Ƿ�����һ���ڵ�
	 * 
	 * 
	 * @param previousNode
	 * @return
	 */
	public static Node ReverseByRecursive(Node previousNode) {
		
		if (previousNode ==null || previousNode.getNext()==null) {
			return previousNode;
		}else {
			Node rehead = ReverseByRecursive(previousNode.getNext());
			previousNode.getNext().setNext(previousNode);
			previousNode.setNext(null);
			return rehead;
		}
	}

	
	public static void main(String[] args) {
		LinkedListOnePoint list = new LinkedListOnePoint();
		list.insertNode(0);
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.display();
		
		list.head = ReverseByRecursive(list.head);
		list.display();
		
		
	}
	

}

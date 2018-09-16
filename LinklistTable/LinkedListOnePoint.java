package LinklistTable;

import java.text.SimpleDateFormat;

public class LinkedListOnePoint {
	
	/**
	 * 链表节点定义
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
	 * 在链表表头插入一个节点（入栈）
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
	 * 删除链表表头节点（出栈）
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
	 * 删除节点
	 * 1. 首先需找到删除的节点
	 * 2.然后让前一个节点指向删除节点的下一个节点
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
	 * 判断链表是否存在某个元素
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
			System.out.println("链表为空");
		}
		
		Node n = head;
		
		while (n != null) {
			System.out.print("<-"+n.data);
			n= n.next;
		}
		
		System.out.println();
	}
	
	/**
	 * 插入节点
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
	 * 反转链表（递归）
	 * 
	 * 在反转链表的时候需要判断反转的节点是否还有下一个节点
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

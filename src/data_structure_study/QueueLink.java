package data_structure_study;

public class QueueLink {
	
	private Node head = null;
	private Node tail = null;
	// 入队
	public void enquene(int data) {
		if(tail == null) {
			Node newNode = new Node(data, null);
			head = newNode;
			tail = newNode;
		}else {
			tail.next = new Node(data, null);
			tail = tail.next;
		}
	}
	// 
	public int dequeue() {
		if(head == null) {
			return -1;
		}
		int data = head.data;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		return data;
	}
	public void printAll() {
		Node p = head;
		while(p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		QueueLink ql = new QueueLink();
		ql.enquene(1);
		ql.enquene(2);
		ql.enquene(3);
		System.out.println(ql.dequeue());
		System.out.println(ql.dequeue());
	}
	

	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
	}

}


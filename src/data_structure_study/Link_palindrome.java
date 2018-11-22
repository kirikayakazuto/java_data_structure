package data_structure_study;

import data_structure_test.Test;
import data_structure_test.Test.Node;

public class Link_palindrome {
	private Node head = null;	// 头结点
	//根据值查找
	public Node findByValue(int value) {
		Node p = head;
		while(p != null && p.data != value) {	// 没有找到, 就一直遍历下去
			p = p.next;
		}
		return p;
	}
	// 根据索引查找
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while(p != null && pos != index){
			p = p.next;
			++ pos;
		}
		
		return p;
	}
	// 插入一个数据 -> 头部
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		insertToHead(newNode);
	}
	public void insertToHead(Node newNode) {
		if(head == null) {	
			head = newNode;
		}else {	
			newNode.next = head;
			head = newNode;
		}
	}
	// 插入一个数据 -> 尾部
	public void insertTail(int value) {
		Node newNode = new Node(value, null);
		insertTail(newNode);
	}
	public void insertTail(Node newNode) {
		if(head == null) {
			head = newNode;
		}else {
			Node q = head;
			while(q.next != null) {
				q = q.next;
			}
			newNode.next = q.next;
			q.next = newNode;
		}
	}

	public void insertBefore(Node p, int value) {
		Node newNode = new Node(value, null);
		insertBefore(p, newNode);
	}
	public void insertBefore(Node p, Node newNode) {
		if(p == null) return ;
		if(head == p) {
			insertToHead(newNode);
			return;
		}
		Node q = head;
		while(q != null && q.next != p) {	// 寻找
			q = q.next;
		}
		
		if(q == null) {	// 没有找到p结点, 无法完成插入
			return ;
		}
		
		newNode.next = p;
		q.next = newNode;
	}
	
	// 插入一个数据
	public void insertAfter(Node p, int value) {
		Node newNode = new Node(value, null);
		insertAfter(p, newNode);
	}
	// 插入一个结点
	public void insertAfter(Node p, Node newNode) {
		if(p == null) return ;
	
		newNode.next = p.next;
		p.next = newNode;
	}
	
	public void deleteByNode(Node p) {
		if(p == null || head == null) return ;	
		if(p == head) {	// 删除头结点
			head = head.next;
			return ;                  
		}
		
		Node q = head;
		while(q != null && q.next != p) {
			q = q.next;
	 	}
		if(q  == null) {	// 删除尾结点 是, 也是直接删除, 让上一个结点的next指向尾结点的next
			return ;
		}
		
		q.next = q.next.next;
	}
	public void deleteByValue(int value) {
		if(head == null) return;
		
		Node p = head;
		Node q = null;
		while(p != null && p.data != value) {
			q = p;
			p = p.next;
		}
		if(p == null) return ;
		if(q == null) {
			head = head.next;
		}else {
			q.next = q.next.next;
		}
	}
	public boolean TFResult(Node left, Node right) {
		Node l = left;
		Node r = right;
		
		while(l != null && r != null) {
			if(l.data == r.data) {
				l = l.next;
				r = r.next;
				continue;
			}else {
				break;
			}
		}
		
		if(l == null && r == null) {
			return true;
		}else {
			return false;
		}
	}
	// 回文链表
	public boolean palindrome() {
		if(head == null) {
			return false;
		}else {
			System.out.println("开始执行找到中间节点...");
			Node p = head;
			Node q = head;
			if(p.next == null) {
				System.out.println("只有一个元素");
				return true;
			}
			while(q.next != null && q.next.next != null) {
				p = p.next;
				q = q.next.next;
			}
			System.out.print("找到链表的中点 " + p.data);
			System.out.println("开始执行奇数节点的会问判断...");
			Node leftLink = null;
			Node rightLink = null;
			
			if(q.next == null) {	// 表示这个一个奇数节点链表
				leftLink = inverseLinkList(p);
				rightLink = p;
			}else {					// 表示这是一个偶数结点链表
				leftLink = inverseLinkList(p);
				rightLink = q;
			}
			return TFResult(leftLink, rightLink);
			
		}
		
	}
	public Node inverseLinkList(Node p) {
		Node pre = null;
		Node r = head;
		
		Node next = null;
		while(r != p) {
			next = r.next;
			
			r.next = pre;
			pre = r;
			r = next;
		}
		
		r.next = pre;
		return r;
	}
	// 打印所有元素
	public void printAll() {
		Node p = head;
		while(p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
		
	// 创建一个结点
	public static Node createNode(int value) {
		return new Node(value, null);
	}
		
	public static class Node {
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
	// 单链表反转
	public void reversal_link() {
		
	}
	
	public static void main(String[] args) {
		Test link = new Test();
		int data[] = {1, 2, 2, 3, 2, 1};
		for(int i=0; i<data.length; i++) {
			link.insertTail(data[i]);
		}
		link.printAll();
		
		boolean link_palindrome = link.palindrome();	// 链表是否是回文数
		System.out.println(link_palindrome);
		
		
		
	}
}

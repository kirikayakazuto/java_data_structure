package data_structure_study;

public class CircularQueue {
	
	private int[] items;
	private int n=0;	// 队列的大小
	
	private int head = 0;
	private int tail = 0;
	
	public CircularQueue(int n) {
		this.items = new int[n];
		this.n = n;
	}
	/*
	public boolean enqueue(int data) {
		if((tail + 1) % n == head) {
			return false;
		}
		
		this.items[tail] = data;
		tail = (tail+1) % n;
		return true;
	}
	*/
	public boolean enqueue(int data) {
		if((tail + 1) % n == head) {	// 队列满了
			// 扩大队列
			int[] newQueue = new int[n * 2];
			for(int i=0; i<n; i++) {
				newQueue[i] = this.items[i];
			}
			this.items = newQueue;
			this.n = n * 2;
		}
		this.items[tail] = data;
		tail = (tail+1) % n;
		return true;
	}
	
	public int dequeue() {
		if(head == tail) {	// 空队列
			return -1;
		}
		int ret = this.items[head];
		head = (head + 1) % n;
		return ret;
	}
	
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		cq.enqueue(1);
		
		cq.enqueue(2);
		cq.enqueue(2);
			
		
		System.out.println(cq.dequeue());
	}
	
	
}

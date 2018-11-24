package data_structure_study;

public class QueueArray {
	private int [] items;
	private int n;
	private int head = 0;
	private int tail = 0;
	
	public QueueArray(int n) {
		this.n = n;
		this.items = new int[n]; 
	}
	/*
	public boolean enqueue(int item) {
		if(tail == n) {	// 队列已经满了
			return false;
		}
		this.items[tail++] = item;
		return true;
	}
	*/
	public boolean enqueue(int item) {
		if(tail == n) {	// 尾指针指向数组终点
			if(head == 0) {	// 如果头指针指向数组起点
				return false;
			}
			for(int i=head; i<tail; i++) {
				this.items[i-head] = this.items[i];
			}
			tail -= head;
			head = 0;
			return true;
		}
		this.items[tail++] = item;
		return true;
	}
	
	public int dequeue() {
		if(head == tail) {	// 没有数据
			return -1;
		}
		int ret = this.items[head++];
		return ret;
	}
	
	public static void main(String[] args) {
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.dequeue();
		qa.dequeue();
		qa.enqueue(2);
		qa.enqueue(1);
		
		System.out.println(qa.dequeue());
	}
}

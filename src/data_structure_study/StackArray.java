package data_structure_study;
/**
 * 
 * @author 邓朗
 *
 * 2018年11月24日
 * 
 * 栈 数组的实现
 */
public class StackArray {
	private int[] items;
	private int count;	// 栈内元素的个数
	private int n;	// 栈的大小
	
	public StackArray(int n) {
		items = new int[n];
		this.n = n;
		this.count = 0;
	}
	/*
	public boolean push(int item) {
		if(count == n) {	// 栈内无剩余空间
			return false;
		}
		
		this.items[count] = item;
		++ count;
		return true;
	}
	*/
	// 自动开辟一个新的数组
	public boolean push(int item) {
		if(count == n) {	// 栈内无剩余空间
			// 开辟一个更大的数组
			int[] array = new int[n*2];
			for(int i=0; i<this.count; i++) {
				array[i] = this.items[i];
			}
			this.items = array;
			this.n = n * 2;
		}
		
		this.items[count] = item;
		++ count;
		return true;
	}
	
	public int pop() {
		if(count == 0) {	// 栈内无元素
			return -1;
		}
		int result = this.items[count - 1];
		-- count;
		return result;
	}
	
	public static void main(String[] args) {
		StackArray sa = new StackArray(5);
		for(int i=0; i<8; i++) {
			sa.push(i);
		}
		
		for(int i=0; i<8; i++) {
			System.out.print(sa.pop());
		}
	}
}

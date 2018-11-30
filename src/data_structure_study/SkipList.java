package data_structure_study;

import java.util.Random;

/**
 * 跳表  redis中常用
 * 
 * @author 邓朗
 *
 * 2018年11月29日
 */
public class SkipList {
	// 最大的索引级数
	private static final int MAX_LEVEL = 16;
	// 当前的索引级数
	private int levelCount = 1;
	// 索引的链表   头结点
	private Node head = new Node();	// 带头的链表
	
	private Random r = new Random();
	
	public Node findByValue(int value) {
		Node p = head;
		// 按层次检索
		for(int i=levelCount-1; i>=0; i--) {
			while(p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
		}
		// 检索到 底层 原链表
		if(p.forwards[0] != null && p.forwards[0].data == value) {
			return p.forwards[0];
		}else {
			return null;
		}
	}
	
	public void insert(int value) {
		// 判断当前的结点插入到那一层索引
		int level = randomLevel();	// 5
		
		Node newNode = new Node();
		
		newNode.data = value;		// 1
		newNode.maxLevel = level;	// 5
		Node[] update = new Node[level];	// update.length = 5
		
		for(int i=0; i<level; i++) {
			update[i] = head;				// 初始化 保存头指针
		}
		
		Node p = head;					// 获得头结点 p
		
		for(int i=level-1; i>=0; i--) {		// 
			while(p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}
		// 全为head
		
		for(int i=0; i<level; i++) {
			newNode.forwards[i] = update[i].forwards[i];
			update[i].forwards[i] = newNode;
		}
		
		if(levelCount < level) {
			levelCount = level;
		}
	}
	
	public void delete(int value) {
		 
		Node[] update = new Node[levelCount];
		Node p = head;
		for(int i=levelCount-1; i>=0; i--) {
			while(p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}
		
		if(p.forwards[0] != null && p.forwards[0].data == value) {
			for(int i=levelCount-1; i>=0; i--) {
				if(update[i].forwards[i] != null && update[i].forwards[i].data == value) {
					update[i].forwards[i] = update[i].forwards[i].forwards[i];
				}
			}
		}
	}
	
	public int randomLevel() {
		int level = 1;
		for(int i=1; i<MAX_LEVEL; i++) {
			if(r.nextInt() % 2 == 1) {
				level ++;
			}
		}
		return level;
	}
	/**
	 * forwards[0] 存的是本身
	 */
	public void printAll() {
		Node p = head;
		while(p.forwards[0] != null) {
			System.out.print(p.forwards[0] + " ");
			p = p.forwards[0];
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SkipList sl = new SkipList();
		sl.insert(1);
		sl.insert(2);
		sl.insert(4);
		sl.insert(8);
		sl.insert(5);
		sl.insert(12);
		sl.insert(10);
		
		sl.printAll();
		Node n = sl.findByValue(2);
		System.out.println(n);
	}
	/**
	 * 每一个node 就是
	 * @author 邓朗
	 *
	 * 2018年11月30日
	 */
	public class Node {
		// 结点保存的数据
		private int data = -1;
		// 结点的下一层索引
		private Node[] forwards = new Node[MAX_LEVEL];
		// 
		private int maxLevel = 0;
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");
			
			return builder.toString();
		}
		
		
	}
}

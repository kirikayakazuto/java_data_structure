package data_structure_study;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 
 * @author 邓朗
 *
 * 2018年11月20日
 * 
 * LRU 缓存淘汰算法
 * 
 * 1, 先进先出算法 FIFO
 * 2, 最少使用策略 LFU
 * 3, 最近最少使用策略 LRU
 * 设计思路, 维护一个有序单链表, 越靠近尾部的结点是越早访问的, 当有一个新数据被访问时
 * 我们从表头向表尾遍历链表
 * (1) 如果此数据已经被缓存在链表中, 我们遍历的到这个数据结点, 并将其删除, 插入到表头
 * (2) 如果此数据没有被缓存在链表中, 
 * 		如果当前的缓存没有满, 那么将此节点插入链表的头部
 * 		如果当前的缓存满了, 那么删除链表的表尾结点, 将新结点插入表头
 * 
 * 
 * 链表 单链表, 循环链表, 双向链表
 * 
 * 单链表 查询链表中点的方法, 使用快慢指针, 慢指针每次走一步, 快指针每次走两步, 那么
 * 当快指针查找到链表尾部时, 慢指针恰是链表中点(注意奇数偶数的区别, i=0, j=0; i++, j+=2;
 * 那么当链表长为4是, 中心点为2, 但链表长为5时, 当j=4时, i=2, 这是j只能走一步, i也走一步,
 * 中点为3)
 * 所以判断单链表数 是否是回文数, 
 * 		1, 找到链表中点
 * 		2, 将链表前半段指针反序
 * 		3, 判断两个链表是否相等
 * 		4, 还原链表本身
 * 时间复杂度 o(n)
 * 
 */
public class Link_study {
	public static void main(String[] args) {
		ArrayList<Integer> num_array = new ArrayList<Integer>(10);
		LinkedList<Integer> num_list = new LinkedList<Integer>();
		for(int i=0; i<10; i++) {
			num_array.add(i);
		}
		
		num_list.add(1);
		num_list.add(2);
		num_list.add(3);
		num_list.add(2);
		num_list.add(1);
		for (Integer integ:num_list) {
			System.out.print(integ);
		}
		System.out.println();
		
		// 判断当前num_list是否存储的是一个回文数
		int i=0, j=0, len = num_list.size();
		while(true) {
			if(i >= len && j >= len) {
				break;
			}
		}
		
		
		
	}
}

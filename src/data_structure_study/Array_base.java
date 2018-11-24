package data_structure_study;

import java.util.ArrayList;

/**
 * 
 * @author 邓朗
 *
 * 2018年11月20日
 * 
 *  数组详解
 *  1, 数组适合查找 , 查找一个已知下下标的的数据, 其时间复杂度为o(1)
 *  
 *  JVM 垃圾回收算法核心,  即是对删除的数据进行标记, 不对其直接删除
 *  而是等到当前容器没有存储的位置了, 一次对所有被标记的数据进行删除
 *  提高删除的效率
 *  
 *  一维数组寻址   int array[10] = new int[10];
 *  array[n] 的地址是  array_address + n * type_size(int)
 *  二维数组寻址 int array[10][10] = new int[10][10];
 *  
 *  array[n][m] 的地址是  array_address + (type_size(int) * 10) * n + m *type_size(int); 
 *  
 */
public class Array_base {
	
	public static void main(String[] args) {
		// 数组详解
		ArrayList<Node> array = new ArrayList<Node>();
		
		
	}
	
	// 添加数据
	public void addData(ArrayList<Node> array, int data) {
		
		for(int i=0; i<array.size(); i++) {	// 向list中添加数据
			if(array.get(i).isFlag() == false) {	// 可以添加数据
				array.get(i).data = data;
				return ;
			}
		}
		// 没有可以存数据的空间了, 整理空间
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).isFlag() == true) {
				// 向后移动位置
				array.get(i).setFlag(false);	// 改变标记
			}
		}
		
	}
	// 删除节点
	public void removeDataByIndex(ArrayList<Node> array, int index) {
		array.get(index).setFlag(true);
	}
	// 结点
	private static class Node {
		boolean flag = false;	// 标记
		int data = 0;
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
	}

	
	
}


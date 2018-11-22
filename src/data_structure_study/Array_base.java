package data_structure_study;
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
	// 数组详解
}

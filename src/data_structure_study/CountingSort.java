package data_structure_study;
/**
 * 计数排序   时间复杂度o(n) 的排序算法
 * 对数据有一定的要求, 适合数据的跨度较小的无序列表
 * 且数据全是非负数
 * 
 * @author 邓朗
 *
 * 2018年11月26日
 */
public class CountingSort {
	
	public static void countingSort(int[] array, int len) {
		if(len <= 1) {
			return ;
		}
		// 找到数据中的最大值
		int max = array[0];
		for(int i=1; i<len; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		// end
		// 申请一个数组c, 下标大小为0到max
		int[] c = new int[max + 1];
		for(int i=0; i<max+1; i++) {
			c[i] = 0;
		}
		// end
		// 计算每个元素的个数, 并放入c数组中
		for(int i=0; i<len; i++) {
			c[array[i]] ++;
		}
		// end
		// 依次累加
		for(int i=1; i<max+1; i++) {
			c[i] += c[i-1];
		}
		// end
		int[] r = new int[len];
		// 计算元素的排序位置
		for(int i=len-1; i>=0; i--) {
			int index = c[array[i]] - 1;
			r[index] = array[i];
			c[array[i]]--;
		}
		for(int i=0; i<len; i++) {
			array[i] = r[i];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3, 3, 0, 0, 2, 5, 12, 9, 1};
		countingSort(a, 9);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

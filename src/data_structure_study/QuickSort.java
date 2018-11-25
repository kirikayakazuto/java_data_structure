package data_structure_study;
/**
 * 快速排序
 * 
 * 分治思想 + 递归思想
 * 
 * 对一段无序列表, 任意选一个pivot(分区点), 遍历这个列表,  
 * 将小于pivot放在pivot左边,
 * 将大于pivot放在pivot右边,
 * 从左边序列找一个分区点, 继续上述操作
 * 从右边序列找一个分区点, 继续上述操作
 * 
 * pivot为q点, p为起点, r为终点
 * 那么, p 到 q-1都是小于q的, q +1 到 r 都是大于q的
 * 当 p <= q-1 时, (终止条件) 排序完成
 * 
 * quickSort(p...r) = quickSort(p...q-1) + quickSort(q+1...r);
 * 终止条件 p >= r; (子序列长度为1)
 * 
 * 
 * @author 邓朗
 *
 * 2018年11月25日
 */
public class QuickSort {
	public static void quickSort(int[] array, int len) {
		quickSortInternally(array, 0, len-1);
	}
	
	public static void quickSortInternally(int[] array, int p, int r) {
		if(p >= r) {
			return ;
		}
		// 找到分区点q
		int q = partition(array, p, r);
		// 在左边序列
		quickSortInternally(array, p, q-1);
		// 在右边序列
		quickSortInternally(array, q+1, r);
	}
	// 对一段无序列表, 任意选一个pivot(分区点), 遍历这个列表,  将小于pivot放在pivot左边,将大于pivot放在pivot右边,
	/*
	 * p 到 i-1 是已处理区
	 * i 到 r-1 是未处理区
	 * 
	 *  每次从未处理区拿出一个 与 array[r] 比较, 如果数值小于array[r], 那么将他放入已处理区(交换)
	 *  i 就是已处理区的大小(已处理区的尾指针)
	 *  j 就是未处理指针
	 */
	private static int partition(int[] array, int p, int r) {
		int pivot = array[r];
		int i = p;
		for(int j=p; j<r; j++) {			
			if(array[j] < pivot) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
			}
		}
		int tmp = array[i];
		array[i] = array[r];
		array[r] = tmp;
		
		return i;
	}

	public static void main(String[] args) {
		int[] a = {3, 4, 1, 2, 5, 6, 9, 8, 7};
		quickSort(a, 9);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

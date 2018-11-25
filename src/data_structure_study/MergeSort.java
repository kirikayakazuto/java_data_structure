package data_structure_study;
/**
 * 
 * 归并排序
 * 
 * 使用归并排序排列一个无序列表L, 首先将列表L分成两个子序列, 子序列在分, 
 * 分成长度为2的无序子序列后, 对其排序, 然后两两合并, 直到合并成一个最终有序序列
 * 
 * 公式 MergeSort(p....r) = MergeSort(MergeSort(p...q), MergeSort(q+1...r))
 * 终止条件, p >= r 不在继续分解(前一位数目 >= 后一位数目, 即, 分解成一个个数)
 * 
 * @author 邓朗        
 *
 * 2018年11月25日
 * 
 */
public class MergeSort {
	
	public static void mergeSort(int[] array, int len) {
		mergeSortInternally(array, 0, len-1);
	}
	
	
	private static void mergeSortInternally(int[] array, int p, int r) {
		if(p >= r) {
			return ;
		}
		// int q = (p + r) / 2;
		// 防止（p+r）的和超过int类型最大值
		int q = p + (r - p) / 2;
		// 对p 到 q 中的数据排序
		mergeSortInternally(array, p, q);
		// 对q+1 到 r 中的数据排序
		mergeSortInternally(array, q+1, r);
		// 将两个子序列合并排序
		merge(array, p, q, r);
	}

	// 合并两个有序子序列, 并使结果有序
	private static void merge(int[] array, int p, int q, int r) {

		int[] tmp = new int[r-p+1];
		for(int i=p, j=q+1, k=0; k<tmp.length; k++) {
			if(j > r || i <= q && array[i] < array[j] ) {	// j>r时, 表示第二个子序列已经全部插入完毕, 剩余的直接插入第一个子序列
				tmp[k] = array[i];
				i++;
			}else {
				tmp[k] = array[j];
				j++;
			}
		}
		// 赋值给array		
		for(int i=p, j=0; i<=r; i++, j++) {
			array[i] = tmp[j];
		}
	}


	public static void main(String[] args) {
		int[] a = {3, 4, 1, 2, 5, 6, 9, 8, 7};
		mergeSort(a, 9);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

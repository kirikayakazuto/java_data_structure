package data_structure_study;

public class Sorts {
	// 冒泡排序
	public static void bubbleSort(int[] array, int n) {
		if(n <= 1) {
			return ;
		}
		for(int i=0; i<n; i++) {
			boolean flag = false;
			for(int j=0; j<n-i-1; j++) {
				if(array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
	// 插入排序
	/* 4 5 6 1 3 2
	 * 初始序列的有序度是5(有5个长度为2的有序子序列)
	 * 满序列的度为是 15  n * (n-1) / 2
	 * 所以插入排序的 度 为 15 - 5 = 10;
	 * 即, 插入排序的度 为 逆序度
	 * 
	 * 核心思想, 对一个有序序列, 将后来的值, 插入这个有序序列, 使其一直有序
	 * 
	 * 深入算法, 希尔排序, 见4
	 */
	public static void insertionSort(int[] array, int n) {
		if(n <= 1) return ;
		for(int i=1; i<n; i++) {
			int value = array[i];
			int j = i-1;
			for(; j>=0; j--) {
				if(array[j] > value) {
					array[j+1] = array[j];
				}else {
					break;
				}
			}
			array[j+1] = value;
		}
	}
	// 选择排序
	public static void selectionSort(int[] array, int n) {
		if(n <= 1) return ;
		
		for(int i=0; i<n-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			
			int tmp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = tmp;
		}
	}
	// 希尔排序
	/**
	 * 
	 * @param array
	 * @param len
	 * 
	 * 将一个 无序数列, 根据step(增量)分成几个子序列
	 * 对每个子序列进行排序
	 * 子序列排序完毕后, 将step -= 1, 再分成几个子序列
	 * 对每个子序列进行排序
	 * 当step = 1时,
	 * 对本身这个序列进行排序
	 * 
	 * 由于开始时，step的取值较大，每个子序列中的元素较少，排序速度较快，到排序后期step取值逐渐变小
	 * 子序列中元素个数逐渐增多，但由于前面工作的基础，大多数元素已经基本有序，所以排序速度仍然很快。 
	 * 
	 * 对于step的取值, 至今没有准确的取值量, 以 n/2 向下取整为 step, 核心, 前期排序子序列越乱越好, 后期排序子序列越有序越好
	 * 
	 * 非稳定的排序方法
	 */
	public static void shellSort(int[] array, int len) {
		if(len <= 1) {
			return ;
		}
		int step = len / 2;	// 增量step
		while(step >= 1) {
			for(int i=step; i<len; i++) {
				int value = array[i];
				int j = i - step;
				for(; j>=0; j-=step) {
					if(value < array[j]) {
						array[j+step] = array[j];
					}else {
						break;
					}
				}
				array[j+step] = value;
			}
			step /= 2;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 1, 8, 4 ,5, 6, 7};
		bubbleSort(a, 8);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		int[] a1 = {2, 3, 1, 8, 4 ,5, 6, 7};
		insertionSort(a1, 8);
		for(int i=0; i<a1.length; i++) {
			System.out.print(a1[i] + " ");
		} 
		System.out.println();
		
		int[] a2 = {2, 3, 1, 8, 4 ,5, 6, 7};
		selectionSort(a2, 8);
		for(int i=0; i<a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();
		
		int[] a3 = {2, 3, 1, 8, 4 ,5, 6, 7};
		shellSort(a3, 8);
		for(int i=0; i<a3.length; i++) {
			System.out.print(a3[i] + " ");
		}
		System.out.println();
				
				// 1 20 2
				// 2 23 3
				// 28
	}
}

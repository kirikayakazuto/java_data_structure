package data_structure_study;
/**
 * 二分法
 * 
 * @author 邓朗
 *
 * 2018年11月29日
 */
public class Dichotomy {
	/*
	 * 对已经排序好的递增序列, 且无重复值, 进行二分查找
	 */
	public static int findValueFirst(int[] array, int value) {
		int start = 0;
		int end = array.length - 1;
		
		while(start <= end) {
			int mid = start + ((end - start) >> 1);
			if(value == array[mid]) {
				return mid;
			}
			if(value < array[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	/**
	 * 对于有重复值得 已排序的递增序列 二分查找第几个值
	 * @param array
	 * @param value
	 * @param index	 1(第一个) or -1(最后一个)
	 */
	public static int findValueFirst(int[] array, int value, int index) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + ((end - start) >> 1);
			if(value == array[mid]) {	// 对于已找到的数值
				while(value == array[mid -= 1 * index]);
				return mid+ 1 * index;
			}
			if(value < array[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	/**
	 * 查找第一个大于等于给定值得元素索引
	 * 查找最后一个大于等于给定值得元素索引
	 * @param array
	 * @param value
	 * @param index	 1 or -1
	 * @return
	 */
	public static int dichotomyValue(int[] array, int value, int index) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + ((end - start) >> 1);
			if(value == array[mid]) {	// 对于已找到的数值
				while(value == array[mid -= 1 * index]);	// 向左遍历
				return mid+ 1 * index;
			}
			if(value < array[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		value = array[start];
		while(value == array[start -= 1 * index]);
		return start+ 1 * index;
		
	}
	/**
	 * 查找第一个值等于定值的元素,   
	 * @param array
	 * @param value
	 * @return
	 */
	public static int bsearch(int[] array, int value) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + ((end - start) >> 1); 	// 相当于(start + end) / 2
			if(array[mid] >= value) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		if(start < array.length && array[start] == value) {
			return start;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 8, 9};
		int index = findValueFirst(arr, 8);
		System.out.println(index);
		
		int[] arr1 = {1, 2, 2, 3, 3, 3, 3, 5, 8, 9};
		int index1 = findValueFirst(arr1, 3, 1);
		System.out.println(index1);
		
		int[] arr2 = {1, 2, 4, 6, 6, 6, 6, 9, 11, 20};
		int index2 = dichotomyValue(arr2, 5, -1);
		System.out.println(index2);
		
		int index3 = bsearch(arr2, 6);
		System.out.println(index3);
	}
}

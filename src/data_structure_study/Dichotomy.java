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
			int mid = (start + end) / 2;
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
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 8, 9};
		int index = findValueFirst(arr, 8);
		System.out.println(index);
	}
}

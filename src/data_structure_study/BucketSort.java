package data_structure_study;
/**
 * 
 * 桶排序
 * 
 * @author 邓朗
 *
 * 2018年11月27日
 */
public class BucketSort {
	
	public static void bucketSort(int[] array, int len) {
		if(len <= 1) {
			return ;
		}
		// 
		int max = Integer.MIN_VALUE;
		for(int i=0; i<len; i++) {
			max = Math.max(max, array[i]);
		}
		
		int[] bucket = new int[max+1];
		
		for(int i=0; i<len; i++) {
			bucket[array[i]]++;
		}
		for(int j=0, i=0; j<bucket.length; j++) {
			while(bucket[j]-- > 0) {
				array[i++] = j;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = {3, 2, 1, 4, 5, 6, 9, 8, 7};
		bucketSort(a, 9);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

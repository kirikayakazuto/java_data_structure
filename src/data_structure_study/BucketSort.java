package data_structure_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 
 * 桶排序
 * 
 * @author 邓朗
 *
 * 2018年11月27日
 */
public class BucketSort {
	
	int bucketSize = 10;	// 桶大小
	int arraySize = 10000;	// 数组大小
	
	public void bucketSort(int[] array, int len) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> bucket[] = new ArrayList[bucketSize];
		for(int i=0; i<array.length; i++) {
			int temp = array[i] / 10000;
			if(bucket[temp] == null) {
				bucket[temp] = new ArrayList<Integer>();
			}
			bucket[temp].add(array[i]);
		}
		
		for(int j=0; j<bucketSize; j++) {	// 桶的个数
			insertSort(bucket[j]);
		}
		int count = 0;
		for(int i=0; i<bucketSize; i++) {
			for(int j=0; j<bucket[i].size(); j++) {
				array[count] = bucket[i].get(i);
				count++;
			}
		}
		
	}
	
	public void insertSort(ArrayList<Integer> list) {
		Collections.sort(list);
	}
	
	public int[] getArray() {
		int[] array = new int[arraySize];
		Random r = new Random();
		for(int i=0; i<arraySize; i++) {
			array[i] = r.nextInt(10000);
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		BucketSort bs = new BucketSort();
		int[] array = bs.getArray();
		bs.bucketSort(array, array.length);
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

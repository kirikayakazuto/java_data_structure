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
				
				
	}
}

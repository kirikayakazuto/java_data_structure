package data_structure_study;
/**
 * s
 * @author 邓朗
 *
 * 2018年11月22日
 * 
 * 哨兵模式, 在边界放置一个标记(卫士), 每次遍历时与卫士比较,即可检查是否越界
 */
public class Study3 {
	public static void main(String[] args) {
		
	}
	// 一般的查询方法
	public int find_value(int[] array, int key) {
		for(int i=0; i<array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	// 哨兵模式的查询方法
	public int find_value_sentry(int[] array, int key) {
		int len = array.length;
		if(array[len - 1] == key) {
			return len - 1;
		}
		
		array[len-1] = key;
		int i=0;
		while(array[i] != key) {	// 减少了 i < len 的操作
			i++;
		}
		if(i == len-1){
			return -1;
		}
		return i;
	}
}

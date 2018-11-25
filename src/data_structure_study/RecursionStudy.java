package data_structure_study;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 邓朗
 *
 * 2018年11月25日
 * 
 * 上台阶, 一次走一步或者两步, 共n个台阶, 求有多少种走法 
 *	解析, 每次上台阶时, 可以选择走1步, 或两步, 即台阶数量每次减少1或2,
 *	f(n-1) 或 f(n-2)
 *	当台阶只剩下 1阶(只能走1步, 一种可能) = 1;, 或 2阶时(走两个一步, 或者 走一个两步, 两种可能) = 2;
 * 从上述文字可得  递归公式为 
 * 	ret = f(n-1) + f(n-2);
 * 终止条件为
 * 	if(n==1) return 1;
 * 	if(n==2) return 2;
 */
public class RecursionStudy {
	public static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		System.out.println(f(20));
		
		System.out.println(nof(20));
		
		
	}
	// 递归实现
	public static int f(int steps) {
		if(steps == 1) {
			return 1;
		}
		if(steps == 2){
			return 2;
		}
		
		if(m.containsKey(steps)) {
			return m.get(steps);
		}
		int ret = f(steps-1) + f(steps-2);
		m.put(steps, ret);
		
		return ret;
	}
	// 非递归实现
	public static int nof(int steps) {
		if(steps == 1) {
			return 1;
		}
		if(steps == 2) {
			return 2;
		}
		
		int ret = 0;
		int pre = 2;
		int prepre = 1;
		for(int i=3; i<=steps; i++) {
			ret = pre + prepre;
			prepre = pre;
			pre = ret;
		}
		return ret;
	}
}

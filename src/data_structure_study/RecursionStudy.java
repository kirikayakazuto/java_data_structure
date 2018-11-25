package data_structure_study;
/**
 * 
 * @author 邓朗
 *
 * 2018年11月25日
 * 
 * 上台阶, 一次走一步或者两步, 共n个台阶, 求有多少种走法 
 */
public class RecursionStudy {
	public static void main(String[] args) {
		System.out.println(f(4));
	}
	
	public static int f(int steps) {
		if(steps == 1) {
			return 1;
		}
		if(steps == 2){
			return 2;
		}
		
		return f(steps-1) + f(steps-2);
	}
}

package data_structure_study;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * 
 * @author 邓朗
 *
 * 2018年11月24日
 * 　　一个水分子的质量是3.0*10-23克，一夸脱水的质量是950克。写一个程序输入水的夸脱数n（0 <= n <= 1e10），然后输出水分子的总数。
 * 输入
 * 109.43
 * 输出
 * 3.465283E+027
 */
public class Main101 {
	public static void main(String[] args) {
		
		BigDecimal b = new BigDecimal("3.0E-23");
		BigDecimal n = new BigDecimal(3);
		
		Scanner input = new Scanner(System.in);
		double count = input.nextDouble();
		input.close();
		if(count < 0.0000001) {
			System.out.println("0.000000E+000");
			return ;
		}
		BigDecimal d = new BigDecimal(950.0);
		BigDecimal c = new BigDecimal(count);
			
		d = d.multiply(c);
		d = d.divide(b, 2, BigDecimal.ROUND_HALF_UP);
		
		
		String s = String.format("%1.6e", d);
		String[] s_array = s.split("e");
		char[] s_char = s_array[1].toCharArray();
		String x = "0";
		if(s_char.length <= 3) {	// 位数不够
			for(int i=1; i<3; i++) {
				x += s_char[i];
			}
			if(s_char[0] == '+') {
				System.out.println(s_array[0]+"E+"+x);
			}else {
				System.out.println(s_array[0]+"E-"+x);
			}
		}
		
		
		
		
	}
}

package data_structure_study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 邓朗
 *
 * 2018年11月23日
 * 
 * 
 */
public class Main121 {

	public static void main(String[] args) throws IOException {
		double point1_x, point1_y, point2_x, point2_y, point3_x, point3_y;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String[] c1 = s1.split(" ");
		point1_x = Double.parseDouble(c1[0]);
		point1_y = Double.parseDouble(c1[1]);
		
		String s2 = br.readLine();
		String[] c2 = s2.split(" ");
		point2_x = Double.parseDouble(c2[0]);
		point2_y = Double.parseDouble(c2[1]);
		
		String s3 = br.readLine();
		String[] c3 = s3.split(" ");
		point3_x = Double.parseDouble(c3[0]);
		point3_y = Double.parseDouble(c3[1]);
		
		double len = perimeter(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
		System.out.println(String.format("%.2f", len));
		
		double s = area(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
		System.out.println(String.format("%.2f", s));
		
		double[] r1 = cneter_point(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
		System.out.println(String.format("%.2f", r1[0]) + " " + String.format("%.2f", r1[1]));
		
		
		double[] r2 = weight_point(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
		System.out.println(String.format("%.2f", r2[0]) + " " + String.format("%.2f", r2[1]));
		
		
		
		
	}
	// 周长
	public static double perimeter(
			double point1_x, double point1_y, 
			double point2_x, double point2_y, 
			double point3_x, double point3_y) {
		double len1 = two_point_len(point1_x, point1_y, point2_x, point2_y);
		double len2 = two_point_len(point1_x, point1_y, point3_x, point3_y);
		double len3 = two_point_len(point2_x, point2_y, point3_x, point3_y);
		return len1+len2+len3;
	}
	// 算出两点间的长度
	public static double two_point_len(
			double point1_x, double point1_y,
			double point2_x, double point2_y) {
		
		double x = point1_x - point2_x;
		double y = point1_y - point2_y;
		double len = Math.sqrt(x * x + y * y);
		
		return len;
	}
	// 面积
	public static double area(
			double point1_x, double point1_y, 
			double point2_x, double point2_y, 
			double point3_x, double point3_y) {
		
		double p;
		double s;
		double len1 = two_point_len(point1_x, point1_y, point2_x, point2_y);
		double len2 = two_point_len(point1_x, point1_y, point3_x, point3_y);
		double len3 = two_point_len(point2_x, point2_y, point3_x, point3_y);
		p = (len1 + len2 + len3)/2;
		s = Math.sqrt(p * (p-len1) * (p-len2) * (p-len3));
		return s;
	}
	// 垂直平分线 中点
	public static double[] cneter_point(
			double point1_x, double point1_y, 
			double point2_x, double point2_y, 
			double point3_x, double point3_y) {
		double[] r1 = a_and_b(point1_x, point1_y, point2_x, point2_y);
		double[] r2 = a_and_b(point1_x, point1_y, point3_x, point3_y);
		
		int f1 = 0, f2 = 0;
		if(r1.length >= 3) {	// 垂直x轴
			f1 = 1;
		}
		if(r2.length >= 3) {
			f2 = 1;
		}
		
		// 这两条线的垂直平分线
		// 先求中点
		double x1 = (point1_x + point2_x) / 2;
		double y1 = (point1_y + point2_y) / 2;
		double a1 = 0;
		if(f1 == 1) {	// 垂直于x轴 那么其垂直平分线 a=0;
			a1 = 0;
		}else {
			if(r1[0] < 0.0000001) {	// 平行x轴, 那么其垂直平分线 垂直x轴
				f1 = 2;
			}else {
				a1 = -1 / r1[0];
			}
		}
		
		double b1 = y1 - a1 * x1;
		// 可能出现 斜率为0的情况
		
		double x2 = (point1_x + point3_x) / 2;
		double y2 = (point1_y + point3_y) / 2;
		double a2 = 0;
		
		if(f2 == 1) {	// 垂直于x轴 那么其垂直平分线 a=0;
			a2 = 0;
		}else {
			if(r2[0] < 0.0000001) {	// 平行x轴, 那么其垂直平分线 垂直x轴
				f2 = 2;
			}else {
				a2 = -1 / r2[0];
			}
		}
		double b2 = y2 - a2 * x2;
		
		
		if(f1 == 2) {		// 垂直x轴
			double yy = a2 * x1 + b2;
			double[] r = {x1, yy};
			
			return r;
		}
		if(f2 == 2) {		// 垂直x轴
			double yy = a1 * x2 + b1;
			double[] r = {x2, yy};
			
			return r;
		}
		// 无特殊情况
		double x;
		x = (b1 - b2) / (a2 - a1);	
		double y = a1 * x + b1;
		
		double[] r = {x, y};
		return r;
	}
	
	// 中点  两点之间的中点 与 顶点间连线 的 交点
	public static double[] weight_point(
			double point1_x, double point1_y, 
			double point2_x, double point2_y, 
			double point3_x, double point3_y) {
		// 1 和 2的中点
		double x1 = (point1_x + point2_x) / 2;
		double y1 = (point1_y + point2_y) / 2;
		double[] r1 = a_and_b(x1, y1, point3_x, point3_y);
		
		double x2 = (point1_x + point3_x) / 2;
		double y2 = (point1_y + point3_y) / 2;
		
		double[] r2 = a_and_b(x2, y2, point2_x, point2_y);

		double x, y;
		
		if(r1.length >= 3) {	// 垂直x轴
			x = x1;
			y = r2[0] * x + r2[1];
			double[] r = {x, y};
			return r;
		}
		if(r2.length >= 3) {	// 垂直x轴
			x = x2;
			y = r1[0] * x + r1[1];
			double[] r = {x, y};
			return r;
		}
		// 无特殊 情况
		x = (r1[1]-r2[1]) / (r2[0] - r1[0]);
		y = r1[0] * x + r1[1];
		double[] r = {x, y};
		
		return r;
	}
	// y = ax + b, 求a, b
	public static double[] a_and_b(
			double point1_x, double point1_y,
			double point2_x, double point2_y) {
		boolean flag = false;
		double a = 0, b = 0, x = 0;
		
		if(Math.abs(point2_x - point1_x) < 0.0000001) {	// 底数为0	垂直x轴
			flag = true;
			
			x = point1_x;
		}else {
			a = (point2_y - point1_y)/(point2_x  - point1_x);
		}
		
		// 可能出现斜率为0的情况
		b = point1_y - a * point1_x;
		if(flag == false) {
			double[] r  = {a, b};
			return r;
		}else {
			double[] r = {a, b, x};
			return r;
		}
	}
}


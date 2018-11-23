package data_structure_study;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class puke {
	char num;
	char color;
	
	puke(char num, char color) {
		this.num = num;
		this.color = color;
	}
}

class sort_by_puke implements Comparator<puke> {

	@Override
	public int compare(puke p1, puke p2) {
		
		int num1 = Main122.map1.get(p1.num+"");
		int num2 = Main122.map1.get(p2.num+""); 
		// TODO Auto-generated method stub
		if(num1 > num2) {
			return 1;
		}else if(num1 < num2){
			return -1;
		}else {	// 数值相同, 比较花色
			int num3 = Main122.map1.get(p1.color + "");
			int num4 = Main122.map1.get(p2.color + "");
			 if(num3 > num4) {
				 return 1;
			 }else {
				 return -1;
				 }
			 }
		}
}
	

public class Main122 {
	public static Map<String, Integer > map1 = new HashMap<String, Integer >();
	
	public static void main(String[] args) {	
		map1.put("2", 1);
		map1.put("3", 2);
		map1.put("4", 3);
		map1.put("5", 4);
		map1.put("6", 5);
		map1.put("7", 6);
		map1.put("8", 7);
		map1.put("9", 8);
		map1.put("10", 9);
		map1.put("J", 10);
		map1.put("Q", 11);
		map1.put("K", 12);
		map1.put("A", 13);
		
		map1.put("d", 14);
		map1.put("c", 15);
		map1.put("h", 16);
		map1.put("s", 17);

		
		ArrayList<puke> list = new ArrayList<puke>();
			
		// 黑桃 s 红桃 h 梅花 c 方块 d
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		
		char c_array[] = s.toCharArray();
		for(int i=0; i<c_array.length; i+=2) {
			puke p = new puke(c_array[i], c_array[i+1]);
			list.add(p);
		}
		
		Collections.sort(list, new sort_by_puke());
		
		for(int i=0; i<list.size(); i++) {
			System.out.print("" + list.get(i).num + list.get(i).color + " ");
		}
		
		
		/*
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		
		char a = s.charAt(0);
		char b = s.charAt(1);
		char c = s.charAt(2);
		
		int num = 0;
		// 先转化为10进制
		if(a >= 'A' && a <= 'F') {
			int count = a-'A' + 10;
			count *= 16 * 16;
			num += count;
		}else {
			int count = a-'0';
			count *= 16 * 16;
			num += count;
		}
		
		if(b >= 'A' && b <= 'F') {
			int count = b-'A' + 10;
			count *= 16;
			num += count;
		}else {
			int count = b-'0';
			count *= 16;
			num += count;
		}
		
		if(c >= 'A' && c <= 'F') {
			
			int count = c-'A' + 10;
			num += count;
		}else {
			int count = c-'0';
			num += count;
		}
		
		// num 为十进制数
		System.out.println("Hex: 0x" + s);
		String De3 = String.format("%03d", num);
		System.out.println("Decimal: " + De3);
		String oc = Dto0(num);
		String oc4 = String.format("%04d", Integer.parseInt(oc));
		System.out.println("Octal: " + oc4);
		
		
		// 转为16进制
		// String H = Integer.toHexString(num);
		// System.out.println(H);
		
			
	}
	public static String Dto0(int d) {
		String o = "";
		if(d < 8) {
			o = "" + d;
		}else {
			int c, s=0, n=d, temp=d;
			while(n>=8) {
				s++;
				n = n/8;
			}
			int[] m = new int[s];
			int i=0;
			do{
				c = d/8;
				m[i++] = d % 8;
				d = c;
			}while(c>=8);
			
			o = "" + d;
			for(int j=m.length-1; j>=0; j--) {
				o += m[j];
			}
		}
		return o;
	*/
		
	}

	
	
}



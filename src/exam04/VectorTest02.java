package exam04;

import java.util.ArrayList;

public class VectorTest02 {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		row1.add("홍길동");
		row1.add("100");
		row1.add("80");
		row1.add("90");
		row2.add("이순신");
		row2.add("90");
		row2.add("80");
		row2.add("90");
		
		list.add(row1);
		list.add(row2);
		System.out.println(list);
		
		ArrayList<String> c = new ArrayList<String>();
		c.add("홍길순");
		c.add("100");
		c.add("100");
		c.add("100");
		
		list.set(0, c);
		System.out.println(list);
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
		
	}

}

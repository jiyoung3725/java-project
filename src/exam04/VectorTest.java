package exam04;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		System.out.println(v);
		v.set(1, "k");
		System.out.println(v);
	}

}

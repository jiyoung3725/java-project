import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Stack<String> stack = new Stack<String>();
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("(") || arr[i].equals("[")) {
				stack.add(arr[i]);
			} else {
				if(stack.isEmpty()) {
					System.out.println(0); return;
				}
				if(stack.peek().equals("(") && arr[i].equals(")")) {
					stack.pop();
					stack.push("2");
				} else if(stack.peek().equals("[") && arr[i].equals("]")) {
					stack.pop();
					stack.push("3");
				} else {
					int tmp = 0;
					try {
					while(true) {
						if(stack.isEmpty()) {
							System.out.println(0); return;
						}
						if((stack.peek().equals("(") && arr[i].equals(")"))
							|| (stack.peek().equals("[")&&arr[i].equals("]"))) {
							stack.pop();
							stack.push(tmp+"");
							break;
						}
							if(arr[i].equals(")")) {
								tmp += Integer.parseInt(stack.pop())*2;
							} else if(arr[i].equals("]")) {
								tmp += Integer.parseInt(stack.pop())*3;
							}
						}
					} catch (Exception e) {
						System.out.println(0);
						return;
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			sum+=Integer.parseInt(stack.pop());
		}
		System.out.println(sum);
		
	}
}

      
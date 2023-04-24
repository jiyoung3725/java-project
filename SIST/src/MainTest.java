import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) test();
	}
	public static void test() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n<2) {
			System.out.println(0);
			return;
		}
		boolean[] prime = new boolean[n+1];
		for(int i=2; i<n+1; i++) {
			for(int j=i*2; j<n+1; j+=i) {
				if(!prime[j]) {
					prime[j]=true;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=2; i<n+1; i++) {
			if(!prime[i]) list.add(i);
		}
		int start = 0;
		int end = 0;
		int result = 0;
		int sum = list.get(0);
		while(end<list.size() && start<list.size()) {
			if(sum<=n) {
				if(sum==n) result++;
				end++;
				if(end>=list.size()) break;
				sum+=list.get(end);
			} else if(sum>n) {
				sum-=list.get(start);
				start++;
			} 
		}
		System.out.println(result);
	}
}

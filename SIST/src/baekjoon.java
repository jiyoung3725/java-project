import java.io.*;
import java.util.*;

public class baekjoon {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[1]-a[1]);
    	for(int i=1; i<=n; i++) {
    		pq.add(new int[] {i, Integer.parseInt(br.readLine())});
    	}
    	int cnt = 0;
    	while(pq.peek()[0]!=1) {
    		int[] tmp = pq.poll();
    		
    	}
	}
}
 
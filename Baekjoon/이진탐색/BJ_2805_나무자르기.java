import java.io.*;
import java.util.*;

public class BJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		long[] tree=  new long[N];
		long max=-1;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max<tree[i]) max= tree[i];
		}
		
		long low = 0;
		long high = max;
		while(low<high) {
			long mid = (low+high)/2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(tree[i]>mid) sum += tree[i]-mid;
			}
			if(sum<M) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		System.out.println(high-1);
	}
}

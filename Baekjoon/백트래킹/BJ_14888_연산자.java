import java.io.*;
import java.util.StringTokenizer;

public class BJ_14888_연산자 {

	static int N;
	static int max,min;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int add = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int pro = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0,add,minus,pro,div,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int count, int add, int minus, int pro, int div, int total) {
		if(count==N-1) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		if(add>0) {
			add--;
			total += arr[count+1];
			dfs(count+1,add,minus,pro,div,total);
			add++;
			total -= arr[count+1];
		}
		if(minus>0) {
			minus--;
			total -= arr[count+1];
			dfs(count+1,add,minus,pro,div,total);
			minus++;
			total += arr[count+1];
		}
		if(pro>0) {
			pro--;
			total *= arr[count+1];
			dfs(count+1,add,minus,pro,div,total);
			pro++;
			total /= arr[count+1];
		}
		if(div>0) {
			div--;
			total /= arr[count+1];
			dfs(count+1,add,minus,pro,div,total);
			div++;
			total *= arr[count+1];
		}
	}
}

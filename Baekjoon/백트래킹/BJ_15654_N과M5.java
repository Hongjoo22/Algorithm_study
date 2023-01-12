import java.io.*;
import java.util.*;

public class BJ_15654_N과M5 {

	static int N,M;
	static int[] arr, answer;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[M];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new  StringBuilder();
		perm(0);
		System.out.print(sb.toString());
	}
	private static void perm(int cnt) {
		if(cnt==M) {
			for(Integer idx:answer) sb.append(idx+" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			answer[cnt] = arr[i];
			perm(cnt+1);
			v[i] = false;
		}
	}

}

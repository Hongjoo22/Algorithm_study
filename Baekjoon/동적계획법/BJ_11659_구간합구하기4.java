import java.io.*;
import java.util.*;

public class BJ_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new  StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		long[] dp = new long[N+1];
		st = new  StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==1) dp[i] = arr[i];
			else dp[i] = dp[i-1]+arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new  StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[end]-dp[start-1]+"\n");
		}
		System.out.println(sb.toString());
	}

}

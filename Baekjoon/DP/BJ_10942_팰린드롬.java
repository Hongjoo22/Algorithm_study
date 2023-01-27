import java.io.*;
import java.util.*;

public class BJ_10942_팰린드롬 {

	static int N,M;
	static int[] arr;
	static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = true;
			if(i>1 && arr[i] == arr[i-1]) dp[i-1][i]=true;
		}
		
		// 구간 길이
		for (int i = 2; i <= N; i++) {
			// 시작 인덱스
			for (int j = 1; j <= N-i; j++) {
				if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			sb.append(dp[x][y]?"1\n":"0\n");
		}
		
		System.out.println(sb.toString());
	}
}

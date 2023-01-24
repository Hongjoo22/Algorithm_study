import java.io.*;
import java.util.*;

public class BJ_17404_RGB거리2 {

	static int N, answer, INF = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		// 현재 행, 열, 초기 열
		dp = new int[N][3][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(dp[i][j], INF);
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new  StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) dp[i][j][j] = arr[i][j];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if(j==0) dp[i][j][k] =  Math.min(dp[i-1][j+1][k], dp[i-1][j+2][k]);	
					else if(j==1) dp[i][j][k] = Math.min(dp[i-1][j-1][k], dp[i-1][j+1][k]);	
					else dp[i][j][k] =  Math.min(dp[i-1][j-1][k], dp[i-1][j-2][k]);
					if(dp[i][j][k]!=INF)  dp[i][j][k]+=arr[i][j];
				}
			}
			
		}

		answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i!=j) answer = Math.min(answer, dp[N-1][i][j]);				
			}
		}
		System.out.println(answer);
	}

}

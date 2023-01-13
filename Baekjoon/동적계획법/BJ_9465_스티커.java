import java.io.*;
import java.util.*;

public class BJ_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] map, DP;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[2][N+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			DP = new int[2][N+1];
			DP[0][1] = map[0][1];
			DP[1][1] = map[1][1];
			
			for (int j = 2; j <= N; j++) {
				DP[0][j] = Math.max(DP[1][j-1], Math.max(DP[0][j-2],DP[1][j-2])) + map[0][j];
				DP[1][j] = Math.max(DP[0][j-1], Math.max(DP[0][j-2],DP[1][j-2])) + map[1][j];
			}
			sb.append(Math.max(DP[0][N], DP[1][N])+"\n");
		}
		System.out.print(sb.toString());
	}

}


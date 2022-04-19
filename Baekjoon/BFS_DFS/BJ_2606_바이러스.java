import java.io.*;
import java.util.*;

public class BJ_2606_바이러스 {

	static int N,count;
	static int[][] map;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r =  Integer.parseInt(st.nextToken())-1;
			int c =  Integer.parseInt(st.nextToken())-1;
			map[r][c] = map[c][r] = 1;
		}
		v[0]=true;
		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int r) {
		for (int i = 0; i < N; i++) {
			if(i==r || v[i]) continue;
			if(map[r][i]==1||map[i][r]==1) {
				v[i] = true;
				count++;
				dfs(i);
			}
		}
	}

}

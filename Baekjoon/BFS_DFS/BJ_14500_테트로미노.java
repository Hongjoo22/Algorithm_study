import java.io.*;
import java.util.*;

public class BJ_14500_테트로미노 {

	static int N,M,max;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]  = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] v = new boolean[N][M];
		max=-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(v,i,j,1,map[i][j]);
				v[i][j] = false; // ㄴ 자 모형을 위해
				//  bfs 모양 따로
				if(!(i==0 && j==0) && !(i==N-1 && j==M-1) && !(i==0 && j==M-1) && !(i==N-1 && j==0)) bfs(i,j);
 			}
		}
		System.out.println(max);
	}
	private static void bfs(int r, int c) {
		if(r==0 || c==0 || r==N-1 || c==M-1) {
			int sum = map[r][c];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>=N || nc>= M || nr<0 || nc<0) continue;
				sum+=map[nr][nc];
			}
			max = Math.max(max,sum);
		}else {
			int up = map[r][c] + map[r-1][c] + map[r][c-1] + map[r][c+1];
			int right =  map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c+1];
			int down =  map[r][c] + map[r+1][c] + map[r][c-1] + map[r][c+1];
			int left =  map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1];
			max = Math.max(max, Math.max(up, Math.max(down, Math.max(right, left))));
		}
	}
	private static void dfs(boolean[][] v, int r, int c,int count,int sum) {
		if(count==4) {
			max = Math.max(max,sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=N || nc>= M || nr<0 || nc<0 ||v[nr][nc]) continue;
			v[nr][nc]=true;
			dfs(v,nr,nc,count+1,sum+map[nr][nc]);
			v[nr][nc]=false;
		}
	}
}

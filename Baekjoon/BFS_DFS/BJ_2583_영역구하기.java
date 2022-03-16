import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {

	static int M, N, K, cnt;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		v = new boolean[M][N];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken()); 
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = Integer.parseInt(st.nextToken()); 

			int tmp =  M-y1-(y2-y1);
			for (int i = tmp; i < tmp + Math.abs(y2 - y1); i++) {
				for (int j = x1; j <x1 + Math.abs(x2 - x1); j++) {
					map[i][j] = 1;
				}
			}
		}
		int count=0;
		ArrayList<Integer> li = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0 && !v[i][j]) {
					cnt = 0;
					dfs(i,j);
					count++;
					li.add(cnt);
				}
			}
		}
		System.out.println(count);
		Collections.sort(li);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < li.size(); i++) {
			sb.append(li.get(i)+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void dfs(int r, int c) {
		cnt++;
		v[r][c]=true;
		for (int d = 0; d < 4; d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			if(!cango(nr,nc)) continue;
			if(map[nr][nc] == 0 && !v[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<M && c<N;
	}

}

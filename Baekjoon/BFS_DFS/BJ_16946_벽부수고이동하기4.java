import java.io.*;
import java.util.*;

public class BJ_16946_벽부수고이동하기4 {

	static int N,M;
	static int[][] map, answer;
	static int[][][] dp;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new int[N][M];
		
		v = new boolean[N][M];
		// 같은 구역인지 check, 구역 칸개수
		dp = new int[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 이동공간 기준 같은 구역인지 check + 칸개수 세기
				if(map[i][j]==0 && !v[i][j]) {
					bfs(i,j,idx);
					idx++;
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 벽 부수면서 check
				if(map[r][c]==1) {
					// 주변이 같은 구역이면 pass하기 위해
					HashSet<Integer> set = new HashSet<>();
					int count = 1;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc]==0) {
							if(set.contains(dp[nr][nc][0])) continue;
							set.add(dp[nr][nc][0]);
							count+=dp[nr][nc][1]%10;
						}
					}
					// 출력 조건
					answer[r][c] = count%10;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(answer[i][j]);
			}sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int r, int c, int idx) {
		Queue<int[]> qu = new LinkedList<>();
		Queue<int[]> memo = new LinkedList<>();
		qu.add(new int[] {r,c});
		memo.add(new int[] {r,c});
		v[r][c] = true;
		int count = 1;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc]==0 && !v[nr][nc]) {
					qu.add(new int[] {nr,nc});
					memo.add(new int[] {nr,nc});
					
					v[nr][nc] = true;
					count++;
				}
			}
		}
		
		while(!memo.isEmpty()) {
			int[] cur = memo.poll();

			dp[cur[0]][cur[1]][0] = idx;
			dp[cur[0]][cur[1]][1] = count;
		}
	}

}

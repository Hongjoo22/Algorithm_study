import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17836_공주님구하기 {

	static int N,M,T,time;
	static int[][] map, tmp,tmp2;
	static boolean[][] v,v2;
	static boolean cango;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		time=Integer.MAX_VALUE;
		cango = false;
		bfs(0,0);
		System.out.println(cango?time:"Fail");
	}
	
	private static void bfs(int r, int c) { // 검없을때
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {0,0});
		v[r][c]=true;
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int cr = curr[0];
			int cc = curr[1];
			if(tmp[cr][cc]>=T) return;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc) || v[nr][nc] || map[nr][nc]==1) continue;
				if(nr==N-1 && nc==M-1) {
					time = Math.min(tmp[cr][cc]+1,time);
					cango = true;
					return;
				}
				if(map[nr][nc]==0) {
					v[nr][nc]=true;
					tmp[nr][nc]=tmp[cr][cc]+1;
					qu.add(new int[] {nr,nc});
				}
				if(map[nr][nc]==2) {
					v[nr][nc]=true;
					tmp[nr][nc]=tmp[cr][cc]+1;
					time=Integer.MAX_VALUE;
					cango = false;
					bfs2(nr,nc);
				}
			}
		}
	}
	private static void bfs2(int r, int c) { // 검사용 시 초기화
		Queue<int[]> qu = new LinkedList<>();
		v2 = new boolean[N][M];
		tmp2 = new int[N][M];
		tmp2[r][c]=tmp[r][c];
		qu.add(new int[] {r,c});
		v2[r][c]=true;
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int cr = curr[0];
			int cc = curr[1];
			if(tmp2[cr][cc]>=T) return;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc) || v2[nr][nc]) continue;
				if(nr==N-1 && nc==M-1) {
					time = Math.min(tmp2[cr][cc]+1,time);
					cango = true;
					return;
				}
				if(map[nr][nc]==0 || map[nr][nc]==1) {
					v2[nr][nc]=true;
					tmp2[nr][nc]=tmp2[cr][cc]+1;
					qu.add(new int[] {nr,nc});
				}
			}
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17135_캐슬디펜스 {

	static int N,M,D,count,size,max;
	static int[][] map;
	static int[] sel;
	static int[] dr = {0,-1,-1,-1,0};
	static int[] dc = {-1,-1,0,1,1};
	static Queue<int[]> enemy = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sel = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					enemy.add(new int[] {i,j});
				}			
			}
		}
		max=-1;
		size=enemy.size();
		combi(0,0);
		
		System.out.println(max);
	}
	private static void combi(int cnt, int start) {
		if(cnt==3) {
			count=0;
			bfsGroup(sel[0],sel[1],sel[2]);
			max = Math.max(max, count);  // 최대값 비교
			return;
		}
		for (int i = start; i < M; i++) {
			sel[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	private static void bfsGroup(int a, int b, int c) { 
		while(size>0) {
			count += bfs(N-1,a);
			count += bfs(N-1,b);
			count += bfs(N-1,c);
			move();
		}		
	}

	private static void move() {
		int tmp=enemy.size();
		for (int i = 0; i < tmp; i++) {
			int[] curr = enemy.poll();
			int cr = curr[0];
			int cc = curr[1];
			if(map[cr][cc]==1 && cr+1 ==N) {
				size--;
				map[cr][cc]=0;
			}else if(map[cr][cc]==1 && cr < N-1) {
				map[cr][cc]=0;
				map[cr+1][cc]=1;
				enemy.add(new int[] {cr+1,cc});
			}
		}
	}
	private static int bfs(int r, int c) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {r,c});
		int cnt=0;
		boolean[][] v = new boolean[N][M];
		int[][] time = new int[N][M];
		time[r][c]=1;
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int cr = curr[0];
			int cc = curr[1];
			v[cr][cc]=true;
			if(cr==r && map[cr][cc]==1) {
				map[cr][cc]=0;
				cnt++;
				size--;
				return cnt;
			}
			
			for (int d = 0; d < 5; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc)||time[cr][cc]>=D || v[nr][nc]) continue;
				if(map[nr][nc]==1) {
					map[nr][nc]=0;
					cnt++;
					size--;
					return cnt;
				}
				if(map[nr][nc]==0) {
					time[nr][nc]=time[cr][cc]+1;
					qu.add(new int[] {nr,nc});
				}
			}
		}
		return 0;
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}

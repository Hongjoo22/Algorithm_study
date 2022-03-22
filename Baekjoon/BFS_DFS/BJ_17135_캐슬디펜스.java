import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17135_캐슬디펜스 {

	static int N,M,D,count,rsize,size,max;
	static int[][] map, map2;
	static int[] sel;
	static int[] dr = {0,-1,0}; // left up right 순으로
	static int[] dc = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sel = new int[3];
		rsize=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) rsize++;	
			}
		}
		max=-1;	
		combi(0,0);	// 행고르기	
		System.out.println(max);
	}
	private static void combi(int cnt, int start) {
		if(cnt==3) {
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
		count=0;
		map2 = new int[N][M];
		for (int i = 0; i < map.length; i++) { // M이 아닌 map.length로..(여기서 하루 낭비)
			System.arraycopy(map[i], 0, map2[i], 0, map[0].length); // 깊은복사로 해야 원본값이 안변함!!(여기서도 하루낭비)
		}
		size = rsize; 
		while(size>0) { 
			bfs(N-1,a);
			bfs(N-1,b);
			bfs(N-1,c);
			move();
		}	
	}

	private static void move() { // 활을 다 쏘고나서 적의 이동 및 맞춘 적 한번에 없애기
		for (int i = N-1; i >=0; i--) { // 끝부터해야 중복발생 x
			for (int j = 0; j < M; j++) {
				if(map2[i][j]==1 && i+1 ==N) {
					size--;
					map2[i][j]=0;
				}else if(map2[i][j]==1 && i < N-1) { 
					map2[i][j]=0;
					map2[i+1][j]=1;
				}else if(map2[i][j]==-1) {
					size--;
					map2[i][j]=0;
				}
			}
		}		
	}
	private static void bfs(int r, int c) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {r,c});
		if(map2[r][c]==1 || map2[r][c]==-1) {
			if(map2[r][c]==1) count++; // 최초로 맞췄을때만
			map2[r][c]=-1;
			return;
		}

		boolean[][] v = new boolean[N][M];
		int[][] time = new int[N][M];
		time[r][c]=1;
		v[r][c]=true;
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int cr = curr[0];
			int cc = curr[1];
			if(time[cr][cc]>=D) break;
			for (int d = 0; d < 3; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc) || v[nr][nc]) continue;
				if(map2[nr][nc]==1 || map2[nr][nc]==-1) {
					if(map2[nr][nc]==1) count++; // 최초로 맞췄을때만
					map2[nr][nc]=-1;					
					qu.clear();
					return;
				}
				if(map2[nr][nc]==0) {
					time[nr][nc]=time[cr][cc]+1;
					qu.add(new int[] {nr,nc});
					v[nr][nc]=true;
				}
			}
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}

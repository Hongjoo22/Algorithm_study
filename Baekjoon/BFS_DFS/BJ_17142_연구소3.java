import java.io.*;
import java.util.*;

public class BJ_17142_연구소3 {
	
	static int N,M,empty,size,min;
	static int[][] map;
	static int[] res;
	static ArrayList<int[]> virus;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 바이러스 놓을 수 있는 구간개수
		map  = new int[N][N];
		virus = new ArrayList<>();
		empty = size= 0;
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					empty++; // 빈공간
					map[i][j]=-4; 
				}
				else if(map[i][j]==2) {
					size++; // 바이러스 개수
					map[i][j] =-3; // 모두 비활성 바이러스로 만들기
					virus.add(new int[] {i,j});
				}else if(map[i][j]==1) {
					map[i][j] = -1; // 벽
				}
			}
		}
		res = new int[M];	
		min  = Integer.MAX_VALUE; // 최소시간
		combi(0,0);
		System.out.println(min==Integer.MAX_VALUE?(-1):min); // 모든경우의 수가 불가능하다면(갱신이 안됐다면)
	}
	private static void combi(int cnt, int start) {
		if(cnt==M) {
			int[][] tmap = new int[N][N]; // 시험용 map
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, tmap[i], 0, N);
			}
			for (int i = 0; i < M; i++) {
				int cur[] = virus.get(res[i]);
				tmap[cur[0]][cur[1]] = 0; //활성바이러스로만들기
			}
			int count = bfs(tmap,res);
		
			if(count==-1) count = Integer.MAX_VALUE; // 불가능한 케이스라면 갱신 x
			min = Math.min(min,count);
			return;
		}
		for (int i = start; i < size; i++) {
			res[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	private static int bfs(int[][] tmap, int[] vir) { // 바이러스 활동
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[][] v = new boolean[N][N];
		int count = empty; // 빈공간 세기
		for (int i = 0; i < vir.length; i++) {
			int cur[] = virus.get(vir[i]);
			qu.add(new int[] {cur[0], cur[1]}); // 활성바이러스 넣기
		}
		
		int time = 0; //시간세기
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			v[cur[0]][cur[1]] = true;
			if(count==0) break; // 모두 바이러스로 가득차면
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=N)continue;
				if(v[nr][nc] || tmap[nr][nc]==-1) continue; //벽이거나 방문
				if(tmap[nr][nc]==-3) { //비활성이면
					tmap[nr][nc] = tmap[cur[0]][cur[1]]+1;
					v[nr][nc] = true;
					qu.add(new int[] {nr,nc});
				}else if(tmap[nr][nc] == -4) { // 빈공간 이라면
					count--; // 빈공간 없애기
					tmap[nr][nc] = tmap[cur[0]][cur[1]]+1;
					v[nr][nc] = true;
					qu.add(new int[] {nr,nc});
					time = Math.max(tmap[nr][nc], time); // 최소시간 구하기
				}		
			}			
		}		
		if(count!=0) time=-1;
		return time;
	}
}

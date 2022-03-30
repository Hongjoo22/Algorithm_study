import java.io.*;
import java.util.*;

public class BJ_2638_치즈 {

	static int R,C,count;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		count=0;
		for (int i = 0; i < R; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==1) count++;
			}
		}
		int time=0;
		while(count!=0) {
			time++;
			bfs();
			check();
		}
		System.out.println(time);
	}

	private static void check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>1) map[i][j]=1;
			}
		}
	}

	private static void bfs() {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {0,0});
		boolean[][] v = new boolean[R][C];
		v[0][0]=true;		
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(!cango(nr,nc) || v[nr][nc]) continue;
				if(map[nr][nc]>=1) {
					map[nr][nc]++;
					if(map[nr][nc]>2) {
						map[nr][nc]=0;
						count--;	
						v[nr][nc]=true;
					}		
				}else if(map[nr][nc]==0) {
					qu.add(new int[] {nr,nc});
					v[nr][nc]=true;
				}				
			}
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}

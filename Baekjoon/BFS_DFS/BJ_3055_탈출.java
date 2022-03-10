import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출 {

	static int R,C;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int[][] go = new int[R][C];
		int[][] water = new int[R][C];
		Queue<int[]> move = new LinkedList<int[]>();
		Queue<int[]> wm = new LinkedList<int[]>();
		
		for (int i = 0; i < R; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j]=cs[j];
				if(map[i][j]=='S') {
					go[i][j]=1;
					move.add(new int[] {i,j,0});
				}else if(map[i][j]=='*') {
					water[i][j]=1;
					wm.add(new int[] {i,j});
				}else { // 비버굴, 돌, 평지
					go[i][j]=-1;
					water[i][j]=-1;
				}
			}					
		}
		//water first
		while(!wm.isEmpty()) {
			int[] cur = wm.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc) || map[nr][nc]=='D'|| map[nr][nc]=='X'||water[nr][nc]>=1) continue;				
				water[nr][nc] = water[cr][cc]+1;
				wm.add(new int[] {nr,nc});				
			}
		}
		//moving
		
		while(!move.isEmpty()) {
			int[] cur = move.poll();
			int cr = cur[0];
			int cc = cur[1];
			int ctime = cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr,nc) || map[nr][nc]=='X' || go[nr][nc]>=1) continue;
				if(map[nr][nc]=='D') {
					System.out.println(ctime+1);
					return;
				}
				if(water[nr][nc]!=-1 && water[nr][nc]<=go[cr][cc]+1) continue;				
				go[nr][nc] = go[cr][cc]+1;
				move.add(new int[] {nr,nc,ctime+1});				
			}
		}
		System.out.println("KAKTUS");
		
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
